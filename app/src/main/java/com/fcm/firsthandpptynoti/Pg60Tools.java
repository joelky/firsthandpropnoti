package com.fcm.firsthandpptynoti;

import android.os.Bundle;
import android.view.MenuItem;

/**
 * Created by joelau on 27/6/16.
 */

public class Pg60Tools extends BaseActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pg60_tools);
    }
    @Override
    protected String setTitleOnToolbar(){
        return "計算工具";
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.Pg60Tools:
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}