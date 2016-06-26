package com.a1sthandpropertiesnoti.firsthandpropnoti;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentManager;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        Toolbar - Set a Toolbar to replace the ActionBar.
        */
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /*
        Drawer Layout (left side drawer)
        */
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        //Drawer Toggle (亖 drawer  button)
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        //Navigation View (drawer) - Initialize
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        /*
        Tab
        */
/*
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);

        //Assigns the ViewPager to TabLayout
        tabLayout.setupWithViewPager(viewPager);
*/
        /*
        FloatingActionButton
        */
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }
    //End Of OnCreate

    /*
    Navigation view - on select
    */
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        Fragment fragment = null;
        Class fragmentClass;


        if (id == R.id.main_pg00) {
//            Toast.makeText(context, "main_pg00", Toast.LENGTH_SHORT).show();
/*            Intent i = new Intent(MainActivity.this, Pg00Main.class);
            startActivity(i);*/
            fragmentClass = Pg00Main.class;
        } else if (id == R.id.new_prop_pg01) {
            fragmentClass = Pg01NewProp.class;
        } else if (id == R.id.my_noti_pg02tb01) {
/*            Intent i = new Intent(MainActivity.this, Pg02Push.class);
            startActivity(i);*/
            fragmentClass = Pg01NewProp.class;
        } else if (id == R.id.my_subcribe_pg02tb02) {
            fragmentClass = Pg01NewProp.class;
        } else if (id == R.id.noti_setting_pg02tb03) {
            fragmentClass = Pg01NewProp.class;
        } else if (id == R.id.hot_pg01) {
            fragmentClass = Pg01NewProp.class;
        } else if (id == R.id.sales_pg01) {
            fragmentClass = Pg01NewProp.class;
        } else if (id == R.id.draw_pg04) {
            fragmentClass = Pg01NewProp.class;
        } else if (id == R.id.settings_pr) {
            fragmentClass = Pg01NewProp.class;
        } else if (id == R.id.nav_share) {
            fragmentClass = Pg01NewProp.class;
        } else if (id == R.id.nav_send) {
            fragmentClass = Pg01NewProp.class;
        }
        else {
            fragmentClass = Pg00Main.class;
        }

/*

        switch(id) {
            case R.id.main_pg00:
                fragmentClass = Pg00Main.class;
                break;
            case R.id.new_prop_pg01:
                fragmentClass = Pg02Push.class;
                break;
            case R.id.my_noti_pg02tb01:
                fragmentClass = Pg02Push.class;
                break;
            default:
                fragmentClass = Pg02Push.class;
        }
*/
        try {
            fragment = (Fragment) fragmentClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }


        // Insert the fragment by replacing any existing fragment
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.flContent, fragment).commit();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    /*
    OptionsMenu
    */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /*
    Tab
    */
/*
    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new OneFragment(), "我的通知");     // OneFragment - tab content page. 我的通知 - Tab name
        adapter.addFragment(new TwoFragment(), "全部通知");
        adapter.addFragment(new ThreeFragment(), "重大通知");
        adapter.addFragment(new FourFragment(), "我的訂閱");
        adapter.addFragment(new FiveFragment(), "設定通知");
        viewPager.setAdapter(adapter);
    }
*/

/*
        class ViewPagerAdapter extends FragmentPagerAdapter {
            private final List<Fragment> mFragmentList = new ArrayList<>();
            private final List<String> mFragmentTitleList = new ArrayList<>();

            public ViewPagerAdapter(FragmentManager manager) {
                super(manager);
            }

            @Override
            public Fragment getItem(int position) {
                return mFragmentList.get(position);
            }

            @Override
            public int getCount() {
                return mFragmentList.size();
            }

            public void addFragment(Fragment fragment, String title) {
                mFragmentList.add(fragment);
                mFragmentTitleList.add(title);
            }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
*/

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.a1sthandpropertiesnoti.fisthandpropnoti/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.a1sthandpropertiesnoti.fisthandpropnoti/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }

    /*
    Android navigation button
    */
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

}
