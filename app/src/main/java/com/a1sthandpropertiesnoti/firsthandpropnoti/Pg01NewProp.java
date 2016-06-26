package com.a1sthandpropertiesnoti.firsthandpropnoti;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by joelau on 27/6/16.
 */

public class Pg01NewProp extends Fragment {

    public Pg01NewProp() {
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
        return inflater.inflate(com.a1sthandpropertiesnoti.firsthandpropnoti.R.layout.pg01_new_prop, container, false);
    }

}