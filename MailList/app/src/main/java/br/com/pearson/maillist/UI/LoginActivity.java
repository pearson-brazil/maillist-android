package br.com.pearson.maillist.UI;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import br.com.pearson.maillist.R;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void showAlert(CharSequence message, View view) {
        Snackbar.make(view, message, Snackbar.LENGTH_LONG).setAction("Action", null).show();

    }
}
