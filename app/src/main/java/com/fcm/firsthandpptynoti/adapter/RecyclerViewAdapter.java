package com.fcm.firsthandpptynoti.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.fcm.firsthandpptynoti.R;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    Context context;

    List<GetDataAdapter> getDataAdapter;

    ImageLoader imageLoader1;

    // Sub-class
    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    class ViewHolder extends RecyclerView.ViewHolder{

        public TextView newPropertyNameChiView;
        public TextView newPropertyNameEngView;
        public TextView newPropertyAddressView;
        public NetworkImageView ImageUrlNewPropertySmallNetworkImageView;

        //constructor
        public ViewHolder(View itemView) {

            super(itemView);

            newPropertyNameChiView = (TextView) itemView.findViewById(R.id.new_ppt_name_chi_view) ;
            newPropertyNameEngView = (TextView) itemView.findViewById(R.id.new_ppt_name_eng_view) ;
            newPropertyAddressView = (TextView) itemView.findViewById(R.id.new_ppt_addr_view) ;

            ImageUrlNewPropertySmallNetworkImageView = (NetworkImageView) itemView.findViewById(R.id.img_url_new_ppty_small_NetworkImageView) ;

        }
    }

    // Constructor (depends on the kind of dataset)
    public RecyclerViewAdapter(List<GetDataAdapter> getDataAdapter, Context context){

        super();
        this.getDataAdapter = getDataAdapter;
        this.context = context;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_items, parent, false);

        ViewHolder viewHolder = new ViewHolder(v);

        return viewHolder;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder Viewholder, int position) {

        GetDataAdapter getDataAdapter1 =  getDataAdapter.get(position);

        imageLoader1 = ServerImageParseAdapter.getInstance(context).getImageLoader();

        imageLoader1.get(getDataAdapter1.getImageUrlNewPropertySmall(),
                ImageLoader.getImageListener(
                        Viewholder.ImageUrlNewPropertySmallNetworkImageView,//Server Image
                        R.mipmap.ic_launcher,//Before loading server image the default showing image.
                        android.R.drawable.ic_dialog_alert //Error image if requested image dose not found on server.
                )
        );

        Viewholder.ImageUrlNewPropertySmallNetworkImageView.setImageUrl(getDataAdapter1.getImageUrlNewPropertySmall(), imageLoader1);
        Viewholder.newPropertyNameChiView.setText(getDataAdapter1.getNewPropertyNameChi());
        Viewholder.newPropertyNameEngView.setText(getDataAdapter1.getNewPropertyNameEng());
        Viewholder.newPropertyAddressView.setText(getDataAdapter1.getNewPropertyAddress());

    }

    @Override
    public int getItemCount() {

        return getDataAdapter.size();
    }
}