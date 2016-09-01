package com.fcm.firsthandpptynoti;

import android.content.Intent;
import android.os.Bundle;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.fcm.firsthandpptynoti.adapter.MyNewPptyData;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.fcm.firsthandpptynoti.adapter.MyRecyclerViewAdapterNewPpty; //MyRecyclerViewAdapterNewPpty extends RecyclerView.Adapter

/*
onCreate
    setContentView
    mMyNewPptyDataToRecyclerViewList = new ArrayList<>();
    --------------------------------------------------------------
    mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);
    --------------------------------------------------------------
    --------------------------------------------------------------
    mRecyclerViewLayoutManager = new LinearLayoutManager(this);
    mRecyclerView.setLayoutManager(mRecyclerViewLayoutManager);
    --------------------------------------------------------------
    JSON_DATA_WEB_CALL()
        new JsonArrayRequest(GET_JSON_DATA_HTTP_URL, JSON_PARSE_DATA_AFTER_WEBCALL(response), ...)
            JSON_PARSE_DATA_AFTER_WEBCALL(JSONArray array)
            for each array
               mMyNewPptyDataFromJson.setImageUrlNewPropertySmall(json.getString(JSON_IMAGE_URL_SMALL))
               ...
               mMyNewPptyDataToRecyclerViewList.add(mMyNewPptyDataFromJson);
    --------------------------------------------------------------
            //RecyclerView > RecyclerView.Adapter
            mMyRecyclerViewAdapterNewPpty = new MyRecyclerViewAdapterNewPpty(mMyNewPptyDataToRecyclerViewList, this);
            mRecyclerView.setAdapter(mMyRecyclerViewAdapterNewPpty);
    --------------------------------------------------------------
            //Item on click listener
            mMyRecyclerViewAdapterNewPpty.setOnItemClickListener(

< json data

*/

public class Pg01NewProp extends BaseActivity {

    private static final String TAG = "Pg01NewProp";
    List<MyNewPptyData> mMyNewPptyDataToRecyclerViewList;
    RecyclerView mRecyclerView;
    RecyclerView.LayoutManager mRecyclerViewLayoutManager;
    MyRecyclerViewAdapterNewPpty mMyRecyclerViewAdapterNewPpty;

    String GET_JSON_DATA_HTTP_URL = "http://104.155.237.246//ImageJsonData.php";

    //DB columns name
    String JSON_IMAGE_URL_SMALL   = "img_path_small";
    String JSON_PROPERTY_NAME_CHI = "ppty_name_chi";
    String JSON_PROPERTY_NAME_ENG = "ppty_name_eng";
    String JSON_PROPERTY_ADDRESS  = "ppty_addr";

    JsonArrayRequest jsonArrayRequest ;

    RequestQueue requestQueue ;

    @Override
    protected String setTitleOnToolbar(){
        return "一手新盤";
    }

    //----------------------------
    // onCreate
    //----------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.pg01_new_prop);

        mMyNewPptyDataToRecyclerViewList = new ArrayList<>();

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);

        // use fixed size item to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        //------------------------------------------
        // LayoutManger
        //------------------------------------------
        // Use LinearLayoutManager
        // shows items in a vertical or horizontal scrolling list (for RecyclerView)
        mRecyclerViewLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mRecyclerViewLayoutManager);

        // 1. get reponse from JSON by volley
        // 2. set values from list to adapter
        // 3. set adapter values recycler view

        //-----------------------------------------------------
        // mMyNewPptyDataToRecyclerViewList - Create data list
        //-----------------------------------------------------
        JSON_DATA_WEB_CALL();

    }   //End of onCreate

    public void JSON_DATA_WEB_CALL(){

        jsonArrayRequest = new JsonArrayRequest(GET_JSON_DATA_HTTP_URL,

                //public interface Listener<T>
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {

                        JSON_PARSE_DATA_AFTER_WEBCALL(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

        requestQueue = Volley.newRequestQueue(this);

        requestQueue.add(jsonArrayRequest);
    }

    public void JSON_PARSE_DATA_AFTER_WEBCALL(JSONArray array){

        for(int i = 0; i<array.length(); i++) {

            MyNewPptyData mMyNewPptyDataFromJson = new MyNewPptyData();

            JSONObject json = null;
            try {

                json = array.getJSONObject(i);

//                mMyNewPptyDataFromJson.setNewPropertyNameChi(URLDecoder.decode(json.getString(JSON_PROPERTY_NAME_CHI), "UTF-8"));
                mMyNewPptyDataFromJson.setImageUrlNewPropertySmall(json.getString(JSON_IMAGE_URL_SMALL));
                mMyNewPptyDataFromJson.setNewPropertyNameChi(json.getString(JSON_PROPERTY_NAME_CHI));
                mMyNewPptyDataFromJson.setNewPropertyNameEng(json.getString(JSON_PROPERTY_NAME_ENG));
                mMyNewPptyDataFromJson.setNewPropertyAddress(json.getString(JSON_PROPERTY_ADDRESS));

            } catch (JSONException e) {

                e.printStackTrace();
            }
            mMyNewPptyDataToRecyclerViewList.add(mMyNewPptyDataFromJson);
        }

        //---------------------------------------------
        // Create an myRecyclerViewAdapter > set adapter to recycler view
        //---------------------------------------------
        mMyRecyclerViewAdapterNewPpty = new MyRecyclerViewAdapterNewPpty(mMyNewPptyDataToRecyclerViewList, this);
        mRecyclerView.setAdapter(mMyRecyclerViewAdapterNewPpty);

        //------------------------------------------
        // #onClick: Revoke onItemClick from adapter
        //------------------------------------------
        mMyRecyclerViewAdapterNewPpty.setOnItemClickListener(
                new MyRecyclerViewAdapterNewPpty.OnRecyclerViewItemClickListener(){
                    @Override
                    public void onItemClick(View view , MyNewPptyData singleViewData){
                        //New page
                        startActivity(new Intent(Pg01NewProp.this, Pg03NewPropDtl.class));
                        //Toast
                        Toast.makeText(Pg01NewProp.this, singleViewData.getNewPropertyNameEng(), Toast.LENGTH_LONG).show();
                    }
                }
        );
    }

}