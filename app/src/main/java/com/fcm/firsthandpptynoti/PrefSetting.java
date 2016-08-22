package com.fcm.firsthandpptynoti;

import android.os.Bundle;

public class PrefSetting extends BaseActivity {

    @Override
    protected String setTitleOnToolbar(){
        return "設定";
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pref_setting);
    }

}