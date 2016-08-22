package com.fcm.firsthandpptynoti;
        import android.os.Bundle;
        import android.support.v4.app.Fragment;
        import android.text.method.ScrollingMovementMethod;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.TextView;

public class Pg02Tab01MyPush extends Fragment{

    TextView scrollable;

    public Pg02Tab01MyPush() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(com.fcm.firsthandpptynoti.R.layout.pg02tab01_mypush, container, false);

        scrollable = (TextView) view.findViewById(R.id.textView1);

        //Enabling scrolling on TextView.
        scrollable.setMovementMethod(new ScrollingMovementMethod());

        // Inflate the layout for this fragment
        // return inflater.inflate(com.fcm.firsthandpptynoti.R.layout.pg02tab01_mypush, container, false);

        return view;

    }



}