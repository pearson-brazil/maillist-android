package br.com.pearson.maillist.UI;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;

import br.com.pearson.maillist.Model.User;
import br.com.pearson.maillist.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnFocusChange;

public class LoginActivity extends AppCompatActivity {

    // Controles de entrada
    @BindView(R.id.email) AutoCompleteTextView emailAutoCompleteTextView;
    @BindView(R.id.password) EditText passwordEditText;;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ButterKnife.bind(this);

    }

    @OnClick(R.id.email_sign_in_button)
    public void submit() {

        User user = new User(emailAutoCompleteTextView.getText(), passwordEditText.getText());

        if (!user.isValidEmail()){
            emailAutoCompleteTextView.setError("E-mail inválido");
        }

        if (!user.isValidPassword()){
            passwordEditText.setError("Senha inválida. Sua senha deve conter pelo menos 4 caracteres.");
        }

        if (user.isValid()) {
            // navega para a próxima tela
            startNextActivity();
        }
    }

    @OnFocusChange({R.id.email, R.id.password})
    public void fieldFocusChanged(View v, boolean hasFocus) {

        User user = new User(emailAutoCompleteTextView.getText(), passwordEditText.getText());

        if (!hasFocus) {
            if (v.getClass() == emailAutoCompleteTextView.getClass()) {
                if (!user.isValidEmail()){
                    emailAutoCompleteTextView.setError("E-mail inválido");
                }
            }else{
                if (!user.isValidPassword()){
                    passwordEditText.setError("Senha inválida. Sua senha deve conter pelo menos 4 caracteres.");
                }
            }
        }
    }

    public void startNextActivity() {
        Intent intent = new Intent(this, ComposeActivity.class);
        startActivity(intent);
    }

}
