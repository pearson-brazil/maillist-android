package br.com.pearson.maillist.UI;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

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
    public void composeButtonClicked() {
        Intent intent = new Intent(this, ComposeActivity.class);
        startActivity(intent);
    }


}
