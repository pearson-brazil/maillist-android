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

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

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
    public static final String BASE_URL = "https://dl.dropboxusercontent.com/u/72381225/";


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
        Ion.with(getContext())
                .load(BASE_URL+"emails.json")
                .asJsonObject()
                .setCallback(new FutureCallback<JsonObject>() {

                    @Override
                    public void onCompleted(Exception e, JsonObject result) {
                        if (result != null) {
                            if (result.has("emails")) {
                                JsonArray list = result.get("emails").getAsJsonArray();
                                Gson gson = new Gson();
                                String json = gson.toJson(list);

                                if (getContext() != null) {
                                    listView.setAdapter(new InboxAdapter(getContext(), Utils.parseEmails(json)));
                                }
                            }
                        }

                    }
                });
    }



    @OnClick(R.id.fab)
    public void composeClicked() {

        composeClickListener.onComposeClicked();
    }

}


