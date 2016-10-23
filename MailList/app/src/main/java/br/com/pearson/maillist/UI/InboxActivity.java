package br.com.pearson.maillist.UI;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.com.pearson.maillist.Model.InboxInterface;
import br.com.pearson.maillist.R;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class InboxActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inbox);
        ButterKnife.bind(this);
    }


    @OnClick(R.id.compose)
    public void composeClicked() {

        Intent intent = new Intent(this, ComposeActivity.class);
        startActivity(intent);
    }
}
