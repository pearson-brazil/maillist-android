package br.com.pearson.maillist.Application;

import android.app.Application;

/**
 * Created by willwfsp on 27/09/16.
 */
public class MailListApplication extends Application {

    private static MailListApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    public static MailListApplication getInstance() {
        return instance;
    }

}
