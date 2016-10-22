package br.com.pearson.maillist.UI.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import br.com.pearson.maillist.Model.Email;
import br.com.pearson.maillist.Model.InboxAdapter;
import br.com.pearson.maillist.Model.InboxInterface;
import br.com.pearson.maillist.R;
import br.com.pearson.maillist.UI.ComposeActivity;
import br.com.pearson.maillist.Utils.Utils;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class InboxFragment extends Fragment {

    private InboxInterface composeClickListener;

    @BindView(R.id.inbox_listView) ListView listView;

    public void setComposeClickListener(InboxInterface composeClickListener) {
        this.composeClickListener = composeClickListener;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_inbox, container, false);

        ButterKnife.bind(this, view);

        initListView();

        return view;
    }

    public void initListView() {
        String json = Utils.loadJSONFromAsset("emails.json");
        listView.setAdapter(new InboxAdapter(this.getContext(), Utils.parseEmails(json)));
    }


    @OnClick(R.id.fab)
    public void composeClicked() {

        composeClickListener.onComposeClicked();
    }

}


