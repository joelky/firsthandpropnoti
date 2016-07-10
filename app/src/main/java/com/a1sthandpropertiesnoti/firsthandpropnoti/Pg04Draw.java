package com.a1sthandpropertiesnoti.firsthandpropnoti;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by joelau on 10/7/16.
 */

public class Pg04Draw extends BaseActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pg04_draw);
    }

    @Override
    protected String setTitleOnToolbar() {
        return "中抽籤結果公報";
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.Pg04Draw:
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}