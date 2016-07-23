package com.a1sthandpropertiesnoti.firsthandpropnoti;

import android.os.Bundle;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.a1sthandpropertiesnoti.firsthandpropnoti.adapter.GetDataAdapter;
import com.a1sthandpropertiesnoti.firsthandpropnoti.adapter.RecyclerViewAdapter;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

public class Pg01NewProp extends BaseActivity {

    List<GetDataAdapter> getDataAdapterToRecyclerView;

    RecyclerView recyclerView;

    RecyclerView.LayoutManager recyclerViewlayoutManager;

    RecyclerView.Adapter recyclerViewadapter;
    String GET_JSON_DATA_HTTP_URL = "http://130.211.250.30/ImageJsonData.php";
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

        getDataAdapterToRecyclerView = new ArrayList<>();

        recyclerView = (RecyclerView) findViewById(R.id.recyclerview1);

        recyclerView.setHasFixedSize(true);

        recyclerViewlayoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(recyclerViewlayoutManager);

        JSON_DATA_WEB_CALL();
    }

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
            getDataAdapterToRecyclerView.add(GetDataAdapterFromJson);
        }

        recyclerViewadapter = new RecyclerViewAdapter(getDataAdapterToRecyclerView, this);

        recyclerView.setAdapter(recyclerViewadapter);
    }
}