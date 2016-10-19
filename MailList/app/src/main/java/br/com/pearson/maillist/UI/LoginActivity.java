package br.com.pearson.maillist.UI;

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

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    // Controles de entrada
    private Button loginButton;
    private EditText passwordEditText;
    private AutoCompleteTextView emailAutoCompleteTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Obtém os controles de entrada definidos no arquivo xml
        loginButton = (Button)findViewById(R.id.email_sign_in_button);
        passwordEditText = (EditText)findViewById(R.id.password);
        emailAutoCompleteTextView = (AutoCompleteTextView)findViewById(R.id.email);

        loginButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        // Instancia um novo usuário baseado nos valores dos controles de entrada
        User user = new User(emailAutoCompleteTextView.getText(), passwordEditText.getText());

        if (user.isValid()){    // Verifica se os dados são válidos
            showAlert("Logado com sucesso!", v);
        }else{
            showAlert("E-mail ou senha inválidos.", v);
        }
    }


    public void showAlert(CharSequence message, View view) {
        Snackbar.make(view, message, Snackbar.LENGTH_LONG).setAction("Action", null).show();
    }
}
