package br.com.pearson.maillist.UI;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.SeekBar;

import br.com.pearson.maillist.Model.User;
import br.com.pearson.maillist.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnEditorAction;
import butterknife.OnFocusChange;

/**
 * Created by pearson on 20/09/16.
 */
public class LoginActivity extends Activity {
    @BindView(R.id.email)
    EditText emailEditText;
    @BindView(R.id.password)
    EditText passwordEditText;

    public static final String USER_DATA = "user_data";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);


    }

    @Override
    protected void onResume() {
        super.onResume();

        SharedPreferences sharedPreferences = getSharedPreferences(USER_DATA, MODE_PRIVATE);
        if (sharedPreferences.contains("email")) {
            startNextActivity();
        }
    }

    @OnFocusChange({R.id.email, R.id.password})
    public void fieldFocusChanged(View v, boolean hasFocus) {

        User user = new User(emailEditText.getText(), passwordEditText.getText());

        if (!hasFocus) {
            if (v.getClass() == emailEditText.getClass()) {
                if (!user.isValidEmail()){
                    emailEditText.setError("E-mail inválido");
                }
            }else{
                if (!user.isValidPassword()){
                    passwordEditText.setError("Senha inválida. Sua senha deve conter pelo menos 4 caracteres.");
                }
            }
        }
    }

    @OnEditorAction(R.id.password)
    public boolean keyboardDoneClicked (EditText view, int actionId) {
        if (actionId == EditorInfo.IME_ACTION_DONE) {
            submit(view);
            dissmisKeyboard();
            return true;
        }

        return false;
    }


    @OnClick(R.id.login)
    public void submit(View view) {

        User user = new User(emailEditText.getText(), passwordEditText.getText());

        if (!user.isValidEmail()){
            emailEditText.setError("E-mail inválido");
        }

        if (!user.isValidPassword()){
            passwordEditText.setError("Senha inválida. Sua senha deve conter pelo menos 4 caracteres.");
        }

        if (user.isValid()) {
            // navega para próxima tela
            saveUserData();
            startNextActivity();
        }
    }

    public void saveUserData () {

        SharedPreferences sharedPreferences = getSharedPreferences(USER_DATA, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("email", emailEditText.getText().toString());
        editor.commit();
    }

    @OnClick(R.id.register)
    public void registerTouched(View view) {
        Snackbar.make(view, "O cadastro de novos usuários não está disponível no momento.", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }

    public void dissmisKeyboard() {
        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(passwordEditText.getWindowToken(), 0);
    }

    public void startNextActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
