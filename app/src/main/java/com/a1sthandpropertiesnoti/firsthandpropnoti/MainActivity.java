package com.a1sthandpropertiesnoti.firsthandpropnoti;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v4.app.FragmentManager;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private Toolbar toolbar;
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
        Initializing Toolbar and setting it as the actionbar
        */
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //getSupportActionBar().setDisplayShowHomeEnabled(true);

        /*
        DrawerLayout (left side drawer)
        */
        //Initializing DrawerLayout and ActionBarToggle
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        //ActionBarToggle (亖 spinning hamburger)
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close) {
            @Override
            public void onDrawerClosed(View drawerView) {
                // Code here will be triggered once the drawer closes as we dont want anything to happen so we leave this blank
                super.onDrawerClosed(drawerView);
            }
            @Override
            public void onDrawerOpened(View drawerView) {
                // Code here will be triggered once the drawer open as we dont want anything to happen so we leave this blank
                super.onDrawerOpened(drawerView);
            }
        };
        //Adds the specified listener to the list of listeners that will be notified of drawer events.
        drawer.addDrawerListener(toggle);
        //calling sync state is necessay or else your hamburger icon wont show up
        toggle.syncState();

        /*
        NavigationView (drawer) - Initialize
        */
        //Initializing NavigationView
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        //Set a listener that will be notified when a menu item is clicked
        navigationView.setNavigationItemSelectedListener(this);

        /*
        Fragment - Include the fragment page: Pg00Main
        */
        Fragment fragment = null;
        Class fragmentClass;
        fragmentClass = Pg00Main.class;
        // Insert the fragment by replacing any existing fragment
        try {
            fragment = (Fragment) fragmentClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.flContent, fragment).commit();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }
    //End Of OnCreate

    /*
    NavigationView - on select
    */
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        Fragment fragment = null;
        Class fragmentClass = null;

        if (id == R.id.main_pg00) {
//            Toast.makeText(context, "main_pg00", Toast.LENGTH_SHORT).show();
//            Intent i = new Intent(MainActivity.this, Pg00Main.class);
//            startActivity(i);
            fragmentClass = Pg00Main.class;
        } else if (id == R.id.new_prop_pg01) {
            fragmentClass = Pg01NewProp.class;
        } else if (id == R.id.my_push_pg02tb01) {
            Intent i = new Intent(MainActivity.this, Pg02Push.class);
            startActivity(i);
//            fragmentClass = Pg02Push.class;
        } else if (id == R.id.my_subcribe_pg02tb04) {
            fragmentClass = Pg01NewProp.class;
        } else if (id == R.id.noti_setting_pg02tb05) {
            fragmentClass = Pg01NewProp.class;
        } else if (id == R.id.hot_pg01) {
            fragmentClass = Pg01NewProp.class;
        } else if (id == R.id.sales_pg01) {
            fragmentClass = Pg01NewProp.class;
        } else if (id == R.id.draw_pg04) {
            fragmentClass = Pg01NewProp.class;
        } else if (id == R.id.tools_pg60) {
            fragmentClass = Pg01NewProp.class;
        } else if (id == R.id.settings_pr) {
            fragmentClass = Pg01NewProp.class;
        } else if (id == R.id.about_pg50) {
            fragmentClass = Pg01NewProp.class;
        } else if (id == R.id.nav_share) {
            fragmentClass = Pg01NewProp.class;
        } else if (id == R.id.nav_send) {
            fragmentClass = Pg01NewProp.class;
        }
        else {
            fragmentClass = Pg00Main.class;
        }

       if (fragmentClass != null) {
           try {
               fragment = (Fragment) fragmentClass.newInstance();
           } catch (Exception e) {
               e.printStackTrace();
           }

           // Insert the fragment by replacing any existing fragment
           FragmentManager fragmentManager = getSupportFragmentManager();
           fragmentManager.beginTransaction().replace(R.id.flContent, fragment).commit();
       }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);

        return true;
    }
    //End of onNavigationItemSelected

    /*
    OptionsMenu
    */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
