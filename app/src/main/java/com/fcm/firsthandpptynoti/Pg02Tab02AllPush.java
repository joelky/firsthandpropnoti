package com.fcm.firsthandpptynoti;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.fcm.firsthandpptynoti.adapter.MyRecyclerViewAdapterAllPush;

import java.util.ArrayList;
import java.util.List;

/*

getActivity() in a Fragment returns the Activity the Fragment is currently associated with.
change "this" to getActivity(), and also getActivity().getResources()

*/

public class Pg02Tab02AllPush extends Fragment {
    private List<String> mList;
    private MyRecyclerViewAdapterAllPush mMyRecyclerViewAdapterAllPush;
    private RecyclerView mRecyclerView;
    TextView scrollable;
//    private StaggeredHomeAdapter mStaggeredHomeAdapter;

/*    @Override
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
 */
    public Pg02Tab02AllPush() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(com.fcm.firsthandpptynoti.R.layout.pg02tab02_allpush,  container, false);

        //setContentView(R.layout.pg02tab02_allpush);
        initData();
        initView(rootView);
        return rootView;
    }

    private void initData() {
        mList=new ArrayList<String>();
        for (int i = 1; i < 20; i++)
        {
            mList.add(i+"");
        }
    }

    private void initView(View rootView) {
        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerview_tab02_allpush);
        //设置GridView
//        setGridView();
        //设置ListView
        setListView();
        //设置瀑布流
//        setWaterfallView();

    }


    public void setListView(){
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);
//        mRecyclerView.addItemDecoration(new DividerItemDecoration(RecyclerViewActivity.this, DividerItemDecoration.VERTICAL_LIST));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mMyRecyclerViewAdapterAllPush=new MyRecyclerViewAdapterAllPush(getActivity(), mList);
        setLister();
        mRecyclerView.setAdapter(mMyRecyclerViewAdapterAllPush);
    }
/*

    public void setGridView(){
        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(4,
                StaggeredGridLayoutManager.VERTICAL));
        mRecyclerView.addItemDecoration(new DividerGridItemDecoration(this));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mMyRecyclerViewAdapterAllPush=new MyRecyclerViewAdapterAllPush(this, mList);
        setLister();
        mRecyclerView.setAdapter(mHomeAdaper);
    }
    public void setWaterfallView(){
        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(4,
                StaggeredGridLayoutManager.VERTICAL));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mStaggeredHomeAdapter=new StaggeredHomeAdapter(this, mList);
        mRecyclerView.setAdapter(mStaggeredHomeAdapter);
    }

*/
    private void setLister(){
        mMyRecyclerViewAdapterAllPush.setOnItemClickListener(new MyRecyclerViewAdapterAllPush.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
            //    Toast.makeText(Pg02Tab02AllPush.this, "点击第" + (position + 1) + "条", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemLongClick(View view, final int position) {
//                new AlertDialog.Builder(Pg02Tab02AllPush.this)
                new AlertDialog.Builder(Pg02Tab02AllPush.this.getActivity())
                        .setTitle("确认删除嘛")
                        .setNegativeButton("取消", null)
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                mMyRecyclerViewAdapterAllPush.removeData(position);
                            }
                        })
                        .show();
            }
        });
    }
}


/*
public class Pg02Tab02AllPush extends Fragment{

    public Pg02Tab02AllPush() {
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
        return inflater.inflate(com.fcm.firsthandpptynoti.R.layout.pg02tab02_allpush, container, false);
    }

}*/
