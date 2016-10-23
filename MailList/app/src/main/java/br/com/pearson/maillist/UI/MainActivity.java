package br.com.pearson.maillist.UI;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import br.com.pearson.maillist.Model.InboxInterface;
import br.com.pearson.maillist.R;
import br.com.pearson.maillist.UI.Fragments.InboxFragment;
import br.com.pearson.maillist.UI.Fragments.OutboxFragment;
import butterknife.BindView;

/**
 * Created by pearson on 20/09/16.
 */
public class MainActivity extends BaseActivity {

    @BindView(R.id.drawer_layout) DrawerLayout drawerLayout;
    @BindView(R.id.nvView) NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setHomeButton(R.drawable.menu);

        setupDrawerContent(navigationView);
    }



    private void setupDrawerContent(NavigationView navigationView) {

        changeToFragment(getInboxFragment());
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {

                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        selectDrawerItem(menuItem);
                        return true;
                    }
                });
    }

    public void selectDrawerItem(MenuItem menuItem) {

        switch(menuItem.getItemId()) {
            case R.id.nav_inbox_fragment:
                changeToFragment(getInboxFragment());
                break;
            case R.id.nav_logout:
                finish();
                return;
            default:
                changeToFragment(getOutboxFragment());
        }

        menuItem.setChecked(true);

        setTitle(menuItem.getTitle());

        drawerLayout.closeDrawers();
    }

    public void changeToFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.flContent, fragment).commit();
    }

    public InboxFragment getInboxFragment() {

        InboxFragment inboxFragment = new InboxFragment();

        final Context context = this;
        inboxFragment.setComposeClickListener(new InboxInterface() {

            @Override
            public void onComposeClicked() {
                Intent intent = new Intent(context, ComposeActivity.class);
                startActivity(intent);
            }
        });
        setTitle("Entrada");

        return inboxFragment;
    }

    public OutboxFragment getOutboxFragment() {

        OutboxFragment outboxFragment = new OutboxFragment();

        setTitle("Saída");

        return outboxFragment;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
    }
}