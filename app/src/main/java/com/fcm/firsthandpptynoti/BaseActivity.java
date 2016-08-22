package com.fcm.firsthandpptynoti;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
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

/**
 * Created by joelau on 10/7/16.
 */
public class BaseActivity extends AppCompatActivity implements
        NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout mDrawerLayoutFull;
    private Toolbar mToolbar;
    private NavigationView mNavigationView;
    private ActionBarDrawerToggle mDrawerToggle;
    private int selectNavItemId;

    @Override
    public void setContentView(@LayoutRes int layoutResID){
        /**
         * This is going to be our actual root layout.
         * Instantiates a layout XML file into its corresponding View objects.
         * It is never used directly. Instead, use getLayoutInflater() or
         * getSystemService(Class) to retrieve a standard LayoutInflater instance
         * that is already hooked up to the current context and correctly configured for the device you are running on
         * android.view.LayoutInflater#inflate(int, android.view.ViewGroup)
         */
        mDrawerLayoutFull = (DrawerLayout) getLayoutInflater().inflate(R.layout.activity_base, null);
        /**
         * {@link FrameLayout} to inflate the child's view. We could also use a {@link android.view.ViewStub}
         *
         */
        FrameLayout activityContainer = (FrameLayout) mDrawerLayoutFull.findViewById(R.id.flContent);
        getLayoutInflater().inflate(layoutResID, activityContainer, true);
        /**
         * Note that we don't pass the child's layoutId to the parent,
         * instead we pass it our inflated layout.
         */
        super.setContentView(mDrawerLayoutFull);

        /*
        Toolbar - Set a Toolbar to replace the ActionBar.
        Initializing Toolbar and setting it as the actionbar
        */
        mToolbar = (Toolbar) findViewById(R.id.toolbar);


        if (useToolbar()) {
            mToolbar.setTitle(setTitleOnToolbar());
            setSupportActionBar(mToolbar);
        }
        else {
            mToolbar.setVisibility(View.GONE);
        }
        /*
        Navigation View
        */
        //
        mNavigationView = (NavigationView) findViewById(R.id.nav_view);

        //Navigation View
        setUpNavigationView();
    }

    /**
     * Helper method that can be used by child classes to
     * specify that they don't want a {@link Toolbar}
     * @return true
     */
    protected boolean useToolbar(){
        return true;
    }
    protected boolean useDrawerToggle() {
        return true;
    }
    protected String setTitleOnToolbar() {
        return "一手樓通知";
    }

    /*
    Drawer Toggle > Navigation View
    */
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    protected void setUpNavigationView()
    {
        //Set a listener that will be notified when a menu item is clicked
        mNavigationView.setNavigationItemSelectedListener(this);

        // 亖 Drawer Toggle
        if(useDrawerToggle()) {
            mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayoutFull, mToolbar
                    , R.string.navigation_drawer_open
                    , R.string.navigation_drawer_close);
            //Adds the specified listener to the list of listeners that will be notified of drawer events.
            mDrawerLayoutFull.addDrawerListener(mDrawerToggle);
            //Synchronize the state of the drawer indicator/affordance with the linked DrawerLayout.
            mDrawerToggle.syncState();
        }
        else if (useToolbar() && null != getSupportActionBar()) {   //getSupportActionBar - Retrieve a reference to this dialog's ActionBar.
            // Use home/back button instead
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeAsUpIndicator(getResources()
                    .getDrawable(R.drawable.abc_ic_ab_back_material, null));
        }
    }

    /**
     * Helper method to allow child classes to opt-out of having the
     * hamburger menu.
     * @return
     */

    @Override
    public boolean onNavigationItemSelected(MenuItem menuItem) {
        mDrawerLayoutFull.closeDrawer(GravityCompat.START);
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
            case R.id.PrefSetting:
                startActivity(new Intent(this, PrefSetting.class));
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