package com.a1sthandpropertiesnoti.firsthandpropnoti;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by joelau on 9/6/16.
 */
/*
public class Pg00Main extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pg00_main);
    }

}
*/
public class Pg00Main extends Fragment {

    public Pg00Main() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(com.a1sthandpropertiesnoti.firsthandpropnoti.R.layout.pg00_main, container, false);
    }

}