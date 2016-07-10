package com.a1sthandpropertiesnoti.firsthandpropnoti;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by joelau on 27/6/16.
 */

public class Pg01NewProp extends BaseActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pg01_new_prop);
    }
    @Override
    protected String setTitleOnToolbar(){
        return "一手新盤";
    }
    /*
    OptionsMenu and seach icon
    */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.Pg01NewProp:
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}