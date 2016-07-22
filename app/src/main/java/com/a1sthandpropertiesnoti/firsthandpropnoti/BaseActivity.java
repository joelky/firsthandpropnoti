package com.a1sthandpropertiesnoti.firsthandpropnoti;

import android.content.Intent;
import android.support.annotation.LayoutRes;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Switch;

/**
 * Created by joelau on 10/7/16.
 */
public class BaseActivity extends AppCompatActivity implements
        NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout fullLayout;
    private Toolbar toolbar;
    private NavigationView navigationView;
    private ActionBarDrawerToggle drawerToggle;
    private int selectNavItemId;

    @Override
    public void setContentView(@LayoutRes int layoutResID){
        /**
         * This is going to be our actual root layout.
         */
        fullLayout = (DrawerLayout) getLayoutInflater().inflate(R.layout.activity_base, null);
        /**
         * {@link FrameLayout} to inflate the child's view. We could also use a {@link android.view.ViewStub}
         */
        FrameLayout activityContainer = (FrameLayout) fullLayout.findViewById(R.id.flContent);
        getLayoutInflater().inflate(layoutResID, activityContainer, true);
        /**
         * Note that we don't pass the child's layoutId to the parent,
         * instead we pass it our inflated layout.
         */
        super.setContentView(fullLayout);

        /*
        Toolbar - Set a Toolbar to replace the ActionBar.
        Initializing Toolbar and setting it as the actionbar
        */
        toolbar = (Toolbar) findViewById(R.id.toolbar);


        if (useToolbar()) {
            toolbar.setTitle(setTitleOnToolbar());
            setSupportActionBar(toolbar);
        }
        else {
            toolbar.setVisibility(View.GONE);
        }
        /*
        DrawerLayout (left side drawer)
        */
        //Initializing DrawerLayout and ActionBarToggle
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        setUpNavigationView();
    }

    /**
     * Helper method that can be used by child classes to
     * specify that they don't want a {@link Toolbar}
     * @return true
     */
    protected boolean useToolbar()
    {
        return true;
    }
    protected String setTitleOnToolbar() { return "一手樓通知"; };
    protected void setUpNavigationView()
    {
        //Set a listener that will be notified when a menu item is clicked
        navigationView.setNavigationItemSelectedListener(this);

        if(useDrawerToggle()) {
            drawerToggle = new ActionBarDrawerToggle(this, fullLayout, toolbar
                    , R.string.navigation_drawer_open
                    , R.string.navigation_drawer_close);
            //Adds the specified listener to the list of listeners that will be notified of drawer events.
            fullLayout.addDrawerListener(drawerToggle);
            drawerToggle.syncState();
        }
        else if (useToolbar() && null != getSupportActionBar()) {
            // Use home/back button instead
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeAsUpIndicator(getResources()
                    .getDrawable(R.drawable.abc_ic_ab_back_material));
        }
    }

    /**
     * Helper method to allow child classes to opt-out of having the
     * hamburger menu.
     * @return
     */
    private boolean useDrawerToggle() {
        return true;
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem menuItem) {
        fullLayout.closeDrawer(GravityCompat.START);
        selectNavItemId = menuItem.getItemId();
        return onOptionsItemSelected(menuItem);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){

        int id = item.getItemId();

        switch(id)
        {
            case R.id.Pg00Main:
                startActivity(new Intent(this, MainActivity.class));
                return true;
            case R.id.Pg01NewProp:
                startActivity(new Intent(this, Pg01NewProp.class));
                return true;
            case R.id.Pg02Tb01MyPush:
                startActivity(new Intent(this, Pg02Push.class));
                return true;
            case R.id.Pg02Tb04MySubs:
                startActivity(new Intent(this, Pg01NewProp.class));
                return true;
            case R.id.Pg02Tb05NotiSetting:
                startActivity(new Intent(this, Pg01NewProp.class));
                return true;
            case R.id.Pg01Hot:
                startActivity(new Intent(this, Pg01NewProp.class));
                return true;
            case R.id.Pg01Sales:
                startActivity(new Intent(this, Pg01NewProp.class));
                return true;
            case R.id.Pg04Draw:
                startActivity(new Intent(this, Pg04Draw.class));
                return true;
            case R.id.Pg60Tools:
                startActivity(new Intent(this, Pg60Tools.class));
                return true;
            case R.id.PrSetting:
                startActivity(new Intent(this, Pg01NewProp.class));
                return true;
            case R.id.Pg50About:
                startActivity(new Intent(this, Pg01NewProp.class));
                return true;
            case R.id.nav_share:
                startActivity(new Intent(this, Pg01NewProp.class));
                return true;
            case R.id.nav_send:
                startActivity(new Intent(this, Pg01NewProp.class));
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}