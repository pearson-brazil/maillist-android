package br.com.pearson.maillist.Model;

/**
 * Created by pearson on 12/09/16.
 */
public class User {
    private CharSequence email = "";
    private CharSequence password = "";
    private CharSequence name = "";

    public User(CharSequence email, CharSequence password) {
        this.email = email;
        this.password = password;
    }

    public User(CharSequence email, CharSequence password, CharSequence name) {
        this.email = email;
        this.password = password;
        this.name = name;
    }

    public boolean isValid() {
        return isValidEmail() && isValidPassword() && isValidName();
    }

    public boolean isValidEmail() {
        if (email == null) {
            return false;
        }

        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    public boolean isValidName() {
        if (name == null) {
            return false;
        }

        if (name == "") {
            return false;
        }

        return true;
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
