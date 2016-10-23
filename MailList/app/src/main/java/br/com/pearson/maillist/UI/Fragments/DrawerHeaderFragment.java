package br.com.pearson.maillist.UI.Fragments;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import br.com.pearson.maillist.R;
import br.com.pearson.maillist.UI.BaseActivity;
import br.com.pearson.maillist.UI.LoginActivity;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class DrawerHeaderFragment extends BaseActivity {

    @BindView(R.id.headerEmail) TextView emailTextView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nav_header);

        SharedPreferences sharedPreferences = getSharedPreferences(LoginActivity.USER_DATA, MODE_PRIVATE);
        String email = sharedPreferences.getString("email", "aluno@pearson.com");

        emailTextView.setText(email);
    }
}
