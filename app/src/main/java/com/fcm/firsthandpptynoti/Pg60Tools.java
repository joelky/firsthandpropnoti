package com.fcm.firsthandpptynoti;

import android.os.Bundle;

/**
 * Created by joelau on 27/6/16.
 */

public class Pg60Tools extends BaseActivity {

    @Override
    protected String setTitleOnToolbar(){
        return "計算工具";
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pg60_tools);
    }

}