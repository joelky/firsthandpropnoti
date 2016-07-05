package com.a1sthandpropertiesnoti.firsthandpropnoti;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Pg02Tab04MySubs extends Fragment{

    public Pg02Tab04MySubs() {
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
        return inflater.inflate(com.a1sthandpropertiesnoti.firsthandpropnoti.R.layout.pg02tab04_mysubs, container, false);
    }

}