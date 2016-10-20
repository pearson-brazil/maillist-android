package br.com.pearson.maillist.Utils;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.SharedPreferences;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

import br.com.pearson.maillist.Application.MailListApplication;
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

}
