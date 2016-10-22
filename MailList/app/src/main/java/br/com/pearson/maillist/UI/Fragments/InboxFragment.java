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
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class InboxFragment extends Fragment {

    private InboxInterface composeClickListener;

    @BindView(R.id.inbox_listView) ListView listView;

    ArrayList<Email> emails = new ArrayList<Email>(Arrays.asList(new Email[]  {
            new Email("Pellentesque aliquet euismod", "Casey Hamilton", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce at vestibulum odio. Vivamus viverra dignissim dictum. Pellentesque aliquet euismod odio eu accumsan."),
            new Email("Pellentesque aliquet euismod", "Sutton Thompson", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce at vestibulum odio. Vivamus viverra dignissim dictum. Pellentesque aliquet euismod odio eu accumsan."),
            new Email("Pellentesque aliquet euismod", "Boone Murray", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce at vestibulum odio. Vivamus viverra dignissim dictum. Pellentesque aliquet euismod odio eu accumsan."),
            new Email("Pellentesque aliquet euismod", "Sophia Owens", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce at vestibulum odio. Vivamus viverra dignissim dictum. Pellentesque aliquet euismod odio eu accumsan."),
            new Email("Pellentesque aliquet euismod", "Bethany Dodson", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce at vestibulum odio. Vivamus viverra dignissim dictum. Pellentesque aliquet euismod odio eu accumsan."),
            new Email("Pellentesque aliquet euismod", "Jerry Morgan", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce at vestibulum odio. Vivamus viverra dignissim dictum. Pellentesque aliquet euismod odio eu accumsan."),
            new Email("Pellentesque aliquet euismod", "Dickson Snider", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce at vestibulum odio. Vivamus viverra dignissim dictum. Pellentesque aliquet euismod odio eu accumsan."),
            new Email("Pellentesque aliquet euismod", "Charity Perry", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce at vestibulum odio. Vivamus viverra dignissim dictum. Pellentesque aliquet euismod odio eu accumsan."),
            new Email("Pellentesque aliquet euismod", "Cleo Joseph", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce at vestibulum odio. Vivamus viverra dignissim dictum. Pellentesque aliquet euismod odio eu accumsan."),
            new Email("Pellentesque aliquet euismod", "Freeman Keller", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce at vestibulum odio. Vivamus viverra dignissim dictum. Pellentesque aliquet euismod odio eu accumsan."),
            new Email("Pellentesque aliquet euismod", "Mercer Meyers", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce at vestibulum odio. Vivamus viverra dignissim dictum. Pellentesque aliquet euismod odio eu accumsan."),
            new Email("Pellentesque aliquet euismod", "Carr Nunez", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce at vestibulum odio. Vivamus viverra dignissim dictum. Pellentesque aliquet euismod odio eu accumsan."),
            new Email("Pellentesque aliquet euismod", "Bartlett Patrick", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce at vestibulum odio. Vivamus viverra dignissim dictum. Pellentesque aliquet euismod odio eu accumsan."),
            new Email("Pellentesque aliquet euismod", "Kirkland Santana", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce at vestibulum odio. Vivamus viverra dignissim dictum. Pellentesque aliquet euismod odio eu accumsan."),
            new Email("Pellentesque aliquet euismod", "Christi Dalton", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce at vestibulum odio. Vivamus viverra dignissim dictum. Pellentesque aliquet euismod odio eu accumsan."),
            new Email("Pellentesque aliquet euismod", "Sears Velasquez", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce at vestibulum odio. Vivamus viverra dignissim dictum. Pellentesque aliquet euismod odio eu accumsan."),
            new Email("Pellentesque aliquet euismod", "Humphrey Crane", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce at vestibulum odio. Vivamus viverra dignissim dictum. Pellentesque aliquet euismod odio eu accumsan."),
            new Email("Pellentesque aliquet euismod", "Letitia Warner", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce at vestibulum odio. Vivamus viverra dignissim dictum. Pellentesque aliquet euismod odio eu accumsan."),
            new Email("Pellentesque aliquet euismod", "Fannie Suarez", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce at vestibulum odio. Vivamus viverra dignissim dictum. Pellentesque aliquet euismod odio eu accumsan."),
            new Email("Pellentesque aliquet euismod", "Luann Harmon", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce at vestibulum odio. Vivamus viverra dignissim dictum. Pellentesque aliquet euismod odio eu accumsan."),
            new Email("Pellentesque aliquet euismod", "Janette House", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce at vestibulum odio. Vivamus viverra dignissim dictum. Pellentesque aliquet euismod odio eu accumsan."),
            new Email("Pellentesque aliquet euismod", "Stephens Mejia", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce at vestibulum odio. Vivamus viverra dignissim dictum. Pellentesque aliquet euismod odio eu accumsan."),
            new Email("Pellentesque aliquet euismod", "Robbie Noel", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce at vestibulum odio. Vivamus viverra dignissim dictum. Pellentesque aliquet euismod odio eu accumsan."),
            new Email("Pellentesque aliquet euismod", "Mays Norton", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce at vestibulum odio. Vivamus viverra dignissim dictum. Pellentesque aliquet euismod odio eu accumsan."),
            new Email("Pellentesque aliquet euismod", "Solis Everett", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce at vestibulum odio. Vivamus viverra dignissim dictum. Pellentesque aliquet euismod odio eu accumsan.")

    }));

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


        listView.setAdapter(new InboxAdapter(this.getContext(), emails));
    }

    @OnClick(R.id.fab)
    public void composeClicked() {

        composeClickListener.onComposeClicked();
    }

}


