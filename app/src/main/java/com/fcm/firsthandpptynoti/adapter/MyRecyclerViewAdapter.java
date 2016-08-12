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

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder> implements View.OnClickListener{

    Context context;

    List<GetDataAdapter> getDataAdapterList;

    ImageLoader imageLoader;

    private OnRecyclerViewItemClickListener mOnItemClickListener = null;

    // Sub-class
    // A ViewHolder describes an item view and metadata about its place within the RecyclerView
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

            //TextView Widget
            newPropertyNameChiView = (TextView) itemView.findViewById(R.id.new_ppt_name_chi_view) ;
            newPropertyNameEngView = (TextView) itemView.findViewById(R.id.new_ppt_name_eng_view) ;
            newPropertyAddressView = (TextView) itemView.findViewById(R.id.new_ppt_addr_view) ;

            ImageUrlNewPropertySmallNetworkImageView = (NetworkImageView) itemView.findViewById(R.id.img_url_new_ppty_small_NetworkImageView) ;

        }
    }

    // Constructor (depends on the kind of dataset)
    public MyRecyclerViewAdapter(List<GetDataAdapter> getDataAdapterList, Context context){

        super();
        this.getDataAdapterList = getDataAdapterList;
        this.context = context;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        // create a new view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_items, parent, false);

        // set the view's size, margins, paddings and layout parameters
        // ...
        ViewHolder viewHolder = new ViewHolder(v);

        //将创建的View注册点击事件
        v.setOnClickListener(this);

        return viewHolder;
    }

    // Replace the contents of a view (invoked by the layout manager)
    // Called by RecyclerView to display the data at the specified position.
    // This method should update the contents of the itemView to reflect the item at the given position
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {

        GetDataAdapter getDataAdapter =  getDataAdapterList.get(position);

        imageLoader = ServerImageParseAdapter.getInstance(context).getImageLoader();

        imageLoader.get(getDataAdapter.getImageUrlNewPropertySmall(),
                ImageLoader.getImageListener(
                        viewHolder.ImageUrlNewPropertySmallNetworkImageView,//Server Image
                        R.mipmap.ic_launcher,//Before loading server image the default showing image.
                        android.R.drawable.ic_dialog_alert //Error image if requested image dose not found on server.
                )
        );

        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        viewHolder.ImageUrlNewPropertySmallNetworkImageView.setImageUrl(getDataAdapter.getImageUrlNewPropertySmall(), imageLoader);
        viewHolder.newPropertyNameChiView.setText(getDataAdapter.getNewPropertyNameChi());
        viewHolder.newPropertyNameEngView.setText(getDataAdapter.getNewPropertyNameEng());
        viewHolder.newPropertyAddressView.setText(getDataAdapter.getNewPropertyAddress());

        //将数据保存在itemView的Tag中，以便点击时进行获取
        viewHolder.itemView.setTag(getDataAdapter);
    }

    //define interface
    public static interface OnRecyclerViewItemClickListener {
        void onItemClick(View view , GetDataAdapter singleViewData);
    }

    @Override
    public void onClick(View v) {
        if (mOnItemClickListener != null) {
            //注意这里使用getTag方法获取数据
            mOnItemClickListener.onItemClick(v,(GetDataAdapter)v.getTag());
        }
    }

    public void setOnItemClickListener(OnRecyclerViewItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }

    @Override
    public int getItemCount() {

        return getDataAdapterList.size();
    }
}