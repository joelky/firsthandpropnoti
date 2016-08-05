package com.fcm.firsthandpptynoti;

import android.os.Bundle;
import android.view.MenuItem;

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