package com.fcm.firsthandpptynoti;

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

import com.fcm.firsthandpptynoti.adapter.GetDataAdapter;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.fcm.firsthandpptynoti.adapter.MyRecyclerViewAdapter;

public class Pg01NewProp extends BaseActivity {

    private static final String TAG = "Pg01NewProp";
    List<GetDataAdapter> getDataAdapterToRecyclerViewList;
    RecyclerView mRecyclerView;
    RecyclerView.LayoutManager mRecyclerViewLayoutManager;
    MyRecyclerViewAdapter mRecyclerViewAdapter;
    private String[] data= new String[] {"aa","bb", "aa","bb", "aa","bb", "aa","bb", "aa","bb","aa","bb", "aa","bb", "aa","bb", "aa","bb", "aa","bb"  };

    String GET_JSON_DATA_HTTP_URL = "http://104.155.237.246//ImageJsonData.php";
//    String GET_JSON_DATA_HTTP_URL = "http://androidblog.esy.es/ImageJsonData.php";
    //DB columns name
    String JSON_IMAGE_URL_SMALL   = "img_path_small";
    String JSON_PROPERTY_NAME_CHI = "ppty_name_chi";
    String JSON_PROPERTY_NAME_ENG = "ppty_name_eng";
    String JSON_PROPERTY_ADDRESS  = "ppty_addr";

    JsonArrayRequest jsonArrayRequest ;

    RequestQueue requestQueue ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.pg01_new_prop);

        getDataAdapterToRecyclerViewList = new ArrayList<>();

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview1);

        // use fixed size item to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mRecyclerViewLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mRecyclerViewLayoutManager);

        // 1. get reponse from JSON by volley
        // 2. set values from list to adapter
        // 3. set adapter values recycler view
        JSON_DATA_WEB_CALL();

    }   //End of onCreate

    public void JSON_DATA_WEB_CALL(){

        jsonArrayRequest = new JsonArrayRequest(GET_JSON_DATA_HTTP_URL,

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

            GetDataAdapter GetDataAdapterFromJson = new GetDataAdapter();

            JSONObject json = null;
            try {

                json = array.getJSONObject(i);

//                GetDataAdapterFromJson.setNewPropertyNameChi(URLDecoder.decode(json.getString(JSON_PROPERTY_NAME_CHI), "UTF-8"));
                GetDataAdapterFromJson.setImageUrlNewPropertySmall(json.getString(JSON_IMAGE_URL_SMALL));
                GetDataAdapterFromJson.setNewPropertyNameChi(json.getString(JSON_PROPERTY_NAME_CHI));
                GetDataAdapterFromJson.setNewPropertyNameEng(json.getString(JSON_PROPERTY_NAME_ENG));
                GetDataAdapterFromJson.setNewPropertyAddress(json.getString(JSON_PROPERTY_ADDRESS));

            } catch (JSONException e) {

                e.printStackTrace();
            }
            getDataAdapterToRecyclerViewList.add(GetDataAdapterFromJson);
        }

        // specify an adapter
        mRecyclerViewAdapter = new MyRecyclerViewAdapter(getDataAdapterToRecyclerViewList, this);
        mRecyclerView.setAdapter(mRecyclerViewAdapter);

        mRecyclerViewAdapter.setOnItemClickListener(new MyRecyclerViewAdapter.OnRecyclerViewItemClickListener(){
            @Override
            public void onItemClick(View view , List<GetDataAdapter> getDataAdapterToRecyclerViewList){
                //Toast.makeText(Pg01NewProp.this, 'C', Toast.LENGTH_LONG).show();
            }
        });
    }
/*

    */
/*
    Button
    *//*

    Button subscribeButton = (Button) findViewById(R.id.subscribeButton);
    subscribeButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            // [START subscribe_topics]
            FirebaseMessaging.getInstance().subscribeToTopic("news");
            Log.d(TAG, "Subscribed to news topic");
            // [END subscribe_topics]
        }
    });

    Button logTokenButton = (Button) findViewById(R.id.logTokenButton);
    logTokenButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Log.d(TAG, "InstanceID token: " + FirebaseInstanceId.getInstance().getToken());
        }
    });
*/

}