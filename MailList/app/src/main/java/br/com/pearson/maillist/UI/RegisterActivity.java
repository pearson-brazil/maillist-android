package br.com.pearson.maillist.UI;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import br.com.pearson.maillist.Model.User;
import br.com.pearson.maillist.R;
import br.com.pearson.maillist.Utils.Utils;
import butterknife.BindView;
import butterknife.OnClick;

public class RegisterActivity extends BaseActivity {

    @BindView(R.id.email) EditText emailEditText;
    @BindView(R.id.password) EditText passwordEditText;
    @BindView(R.id.name) EditText nameEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        setHomeButton(R.drawable.back);
    }


    @OnClick(R.id.register_register)
    public void registerButtonTouched(View view) {


        User user = new User(emailEditText.getText(), passwordEditText.getText(), nameEditText.getText());

        if (!user.isValidEmail()){
            emailEditText.setError("Email inválido");
        }

        if (!user.isValidPassword()){
            passwordEditText.setError("Senha inválida. Sua senha deve conter pelo menos 4 caracteres.");
        }

        if (!user.isValidName()){
            nameEditText.setError("Nome inválido. O campo nome é obrigatório.");
        }

        if (user.isValid()) {

            Utils.setValueToSharedPreferences(Utils.NAME_KEY, nameEditText.getText().toString());
            Utils.setValueToSharedPreferences(Utils.EMAIL_KEY, emailEditText.getText().toString());
            Utils.removeSharedPreferencesKey(Utils.IS_LOGGED_KEY);

            Utils.showSnackbar(view, "Bem vindo! Você foi cadastrado com sucesso. Agora realize o login e comece a usar o MailList.");
        }

    }
}
