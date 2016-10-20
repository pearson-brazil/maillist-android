package br.com.pearson.maillist.UI;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import br.com.pearson.maillist.Memento.Caretaker;
import br.com.pearson.maillist.Memento.Originator;
import br.com.pearson.maillist.R;
import br.com.pearson.maillist.Utils.Utils;
import butterknife.BindView;
import butterknife.OnClick;
import butterknife.OnTextChanged;

/**
 * Created by pearson on 13/09/16.
 */
public class ComposeActivity extends BaseActivity {

    @BindView(R.id.message) EditText messageEditText;

    Caretaker caretaker = new Caretaker();

    Originator originator = new Originator();

    boolean isUndoEnabled = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compose);

        setHomeButton(R.drawable.back);

        setTitle("Escrever");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.compose_menu, menu);
        return true;
    }

    @OnTextChanged(R.id.message)
    public void textChanged(CharSequence s, int start, int before, int count) {

        originator.set(s.toString());
        caretaker.pushMemento(originator.saveToMemento());
        isUndoEnabled = true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        // The action bar home/up action should open or close the drawer.
        switch (item.getItemId()) {
            case R.id.undo:
                if (isUndoEnabled) {
                    messageEditText.setText(originator.restoreFromMemento(caretaker.popMemento()));
                }
                return true;
            case  R.id.send:
                sendMessage();
                return true;
        }


        return super.onOptionsItemSelected(item);
    }

    public void sendMessage() {
        Intent intent = new Intent(Intent.ACTION_SENDTO); // it's not ACTION_SEND
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_SUBJECT, "Subject of email");
        intent.putExtra(Intent.EXTRA_TEXT, "Body of email");
        intent.setData(Uri.parse("mailto:w.policiano@gmail.com")); // or just "mailto:" for blank
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK); // this will make such that when user returns to your app, your app is displayed, instead of the email app.
        startActivity(intent);
    }
}
