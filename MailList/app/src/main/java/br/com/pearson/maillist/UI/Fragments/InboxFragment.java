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

import br.com.pearson.maillist.Model.InboxInterface;
import br.com.pearson.maillist.R;
import br.com.pearson.maillist.UI.ComposeActivity;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class InboxFragment extends Fragment {

    private InboxInterface composeClickListener;

    public void setComposeClickListener(InboxInterface composeClickListener) {
        this.composeClickListener = composeClickListener;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_inbox, container, false);

        ButterKnife.bind(this, view);
        return view;
    }

    @OnClick(R.id.compose)
    public void composeClicked() {

        composeClickListener.onComposeClicked();
    }

}


