package br.com.pearson.maillist.Utils;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.SharedPreferences;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.Toast;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import br.com.pearson.maillist.Application.MailListApplication;
import br.com.pearson.maillist.Model.Email;
import br.com.pearson.maillist.UI.LoginActivity;

/**
 * Created by pearson on 22/09/16.
 */
public class Utils {


    public static final String USER_DATA = "user_data";

    public static final String EMAIL_KEY = "email_key";
    public static final String NAME_KEY = "name_key";
    public static final String IS_LOGGED_KEY = "is_logged_key";

    public static void showSnackbar(View view, String message) {
        Snackbar.make(view, message, Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }

    public static void showToast(Context context, String message) {

        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

    public static SharedPreferences getUserSharedPreferences() {
        return MailListApplication.getInstance().getSharedPreferences(USER_DATA, Context.MODE_PRIVATE);
    }

    public static void setValueToSharedPreferences(String key, String value) {
        SharedPreferences.Editor editor = Utils.getUserSharedPreferences().edit();
        editor.putString(key, value);
        editor.commit();
    }

    public static String getSharedPreferenceValueForKey(String key, String placeholder) {
        return Utils.getUserSharedPreferences().getString(key, placeholder);
    }

    public static void removeSharedPreferencesKey(String key) {
        SharedPreferences.Editor editor = Utils.getUserSharedPreferences().edit();;
        editor.remove(key);
        editor.apply();
    }

    public static String loadJSONFromAsset(String fileName) {
        String json = null;
        try {

            InputStream inputStream = MailListApplication.getInstance().getApplicationContext().getAssets().open(fileName);

            int size = inputStream.available();
            byte[] buffer = new byte[size];

            inputStream.read(buffer);
            inputStream.close();

            json = new String(buffer, "UTF-8");

        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }

        return json;

    }

    public static ArrayList<Email> parseEmails (String jsonString){

        // Novo parser (serializa/deserializa)
        JsonParser parser = new JsonParser();

        // Obtém elemento JSON através parser da jsonString
        JsonElement element = parser.parse(jsonString);

        // Inicializa um ArrayList para guardar os objetos Email
        ArrayList<Email> emailsList = new ArrayList<>();

        // Verifica se o elemento JSON contém apenas um JsonObject ou um conjunto deles
        if (element.isJsonArray()) {

            JsonArray emails = element.getAsJsonArray();
            for (int i = 0; i < emails.size(); i++) {

                // Obtém o JsonObject correspondente do index i do array email
                JsonObject emailJson = emails.get(i).getAsJsonObject();

                // Obtém os valores de cada chave do JsonObject
                String name = emailJson.get("from").getAsString();
                String subject = emailJson.get("subject").getAsString();
                String message = emailJson.get("message").getAsString();

                // Instancia e adiciona um novo objeto Email na lista de e-mails
                emailsList.add(new Email(subject, name, message));
            }
        }

        // Retorna a lista de e-mails
        return  emailsList;

    }



}
