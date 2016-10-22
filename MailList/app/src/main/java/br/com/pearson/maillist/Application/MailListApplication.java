package br.com.pearson.maillist.Application;

import android.app.Application;

import br.com.pearson.maillist.R;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by willwfsp on 27/09/16.
 */
public class MailListApplication extends Application {

    private static MailListApplication instance;

    public static MailListApplication getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/Roboto-Regular.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );

        instance = this;
    }

}
