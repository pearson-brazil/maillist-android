package br.com.pearson.maillist.Model;

/**
 * Created by pearson on 19/10/16.
 */
public class User {
    private CharSequence email = "";
    private CharSequence password = "";

    public User(CharSequence email, CharSequence password) {
        this.email = email;
        this.password = password;
    }

    public boolean isValid() {
        return isValidEmail() && isValidPassword();
    }

    public boolean isValidEmail() {
        if (email == null) {
            return false;
        }

        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    public boolean isValidPassword() {
        if (password == null) {
            return false;
        }

        if (password.length() < 4) {
            return false;
        }

        return true;
    }

}
