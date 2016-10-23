package br.com.pearson.maillist.Utils;

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by pearson on 22/09/16.
 */
public class Utils {

    public static String getLastWord(String sentence) {

        String[] words = sentence.split("\\s+");
        for (int i = 0; i < words.length; i++) {
            // You may want to check for a non-word character before blindly
            // performing a replacement
            // It may also be necessary to adjust the character class
            words[i] = words[i].replaceAll("[^\\w]", "");
        }

        return words[words.length-1];
    }

    public static void showSnackbar(View view, String message) {
        Snackbar.make(view, message, Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }

    public static void showToast(Context context, String message) {

        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

}
