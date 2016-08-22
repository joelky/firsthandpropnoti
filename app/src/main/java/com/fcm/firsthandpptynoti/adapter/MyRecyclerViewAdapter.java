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

//implements interface View.OnClickListener
public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder> implements View.OnClickListener{

    Context context;

    List<GetDataAdapter> getDataAdapterList;

    ImageLoader imageLoader;    //volley.toolbox

    // implement interface: View.OnClickListener
    private OnRecyclerViewItemClickListener mOnRecyclerViewItemClickListener = null;

    // Sub-class
    // A ViewHolder describes an item view and metadata about its place within the RecyclerView
    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    class ViewHolder extends RecyclerView.ViewHolder{

        //Displays text to the user and optionally allows them to edit it. A TextView is a complete text editor,
        //however the basic class is configured to not allow editing; see EditText for a subclass that configures the text view for editing.
        public TextView newPropertyNameChiView;
        public TextView newPropertyNameEngView;
        public TextView newPropertyAddressView;
        public NetworkImageView ImageUrlNewPropertySmallNetworkImageView;

        //constructor
        public ViewHolder(View itemView) {

            //explicitly call the super constructor with parameter
            //invoke parent class RecyclerView.ViewHolder
            //public ViewHolder(View itemView)
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

    // This method calls onCreateViewHolder(ViewGroup, int) to create a new RecyclerView.ViewHolder and
    // initializes some private fields to be used by RecyclerView.
    // Create new views (invoked by the layout manager)
    // Called when RecyclerView needs a new RecyclerView.ViewHolder of the given type to represent an item.
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        // create a new view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_items, parent, false);

        // ViewHolder describes an item view and metadata about its place within the RecyclerView.
        // set the view's size, margins, paddings and layout parameters
        // The new ViewHolder will be used to display items of the adapter using onBindViewHolder(ViewHolder, int, List).
        // Since it will be re-used to display different items in the data set,
        // it is a good idea to cache references to sub views of the View to avoid unnecessary findViewById(int) calls.
        ViewHolder viewHolder = new ViewHolder(v);

        // #onClick: set onclick event to created view
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

        // #onClick: save data in itemView's tag for data retrieve from click
        viewHolder.itemView.setTag(getDataAdapter);
    }

    // #onClick: Called when a view has been clicked. Implements interface View.OnClickListener
    @Override
    public void onClick(View v) {
        if (mOnRecyclerViewItemClickListener != null) {
            //use getTag to get data
            mOnRecyclerViewItemClickListener.onItemClick(v,(GetDataAdapter)v.getTag());
        }
    }

    // #onClick: define interface
    public static interface OnRecyclerViewItemClickListener {
        void onItemClick(View view , GetDataAdapter singleViewData);
    }

    // #onClick:  Revoke from outside: Pg01NewProp > onCreate
    public void setOnItemClickListener(OnRecyclerViewItemClickListener listener) {
        this.mOnRecyclerViewItemClickListener = listener;
    }

    @Override
    public int getItemCount() {

        return getDataAdapterList.size();
    }
}