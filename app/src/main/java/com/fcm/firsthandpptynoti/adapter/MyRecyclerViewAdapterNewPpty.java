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

/*
To use the RecyclerView widget, you have to specify an adapter and a layout manage
A layout manager positions item views inside a RecyclerView and determines when to reuse item views that are no longer visible to the user (Cach viewholder...).
To reuse (or recycle) a view, a layout manager may ask the adapter to replace the contents of the view with a different element from the dataset.
Recycling views in this manner improves performance by avoiding the creation of unnecessary views or performing expensive findViewById() lookups.

RecyclerView provides these built-in layout managers:
LinearLayoutManager：線性佈局
GridLayoutManager：網格佈局
StaggeredGridLayoutManager：交錯網格佈局

 -------------------
|   RecyclerView    |
|  ---------------  |       ---------------          --------------
| | LayoutManager |-|----> |    Adapter    | -----> |    Dataset   |
|  ---------------  |       ---------------          --------------
|___________________|
Adapter: Provides access to the items in your data set, creates views for items, and replaces the content of some of the views with new data items

 -------------------
|  ---------------  |
| |   ViewHolder  | |
| |  -----------  | |
| | | itemView  | | |
| | | textView  | | |
| |  -----------  | |
|  ---------------  |
|  ---------------  |
| |   ViewHolder  | |
| |  -----------  | |
| | | itemView  | | |
| | | textView  | | |
| |  -----------  | |
|  ---------------  |
|___________________|

LayoutManager: A layout manager positions item views inside a RecyclerView and determines when to reuse item views that are no longer visible to the user.
Adapter (MyRecyclerViewAdapterNewPpty):
1. provides access to the items in your data set
2. creates views for items
3. replaces the content of some of the views with new data items when the original item is no longer visible

class ViewHolder
    public ViewHolder(View itemView) {
        newPropertyNameChiView = (TextView) itemView.findViewById(R.id.new_ppt_name_chi_view) ;
onCreateViewHolder
    View mItemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_items_new_ppty, parent, false);
    ViewHolder mViewHolder = new ViewHolder(mItemView);
onBindViewHolder
    MyNewPptyData myNewPptyData =  mMyNewPptyDataList.get(position);
    viewHolder.newPropertyNameChiView.setText(myNewPptyData.getNewPropertyNameChi());

Create ViewHolder view < Create ItemView view < data by position
*/

//implements interface View.OnClickListener
public class MyRecyclerViewAdapterNewPpty extends RecyclerView.Adapter<MyRecyclerViewAdapterNewPpty.ViewHolder> implements View.OnClickListener{

    Context context;
    List<MyNewPptyData> mMyNewPptyDataList;
    ImageLoader mImageLoader;    //volley.toolbox
    // implement interface: View.OnClickListener
    private OnRecyclerViewItemClickListener mOnRecyclerViewItemClickListener = null;

    // Constructor (depends on the kind of dataset)
    public MyRecyclerViewAdapterNewPpty(List<MyNewPptyData> mMyNewPptyDataList, Context context){

        super();
        this.mMyNewPptyDataList = mMyNewPptyDataList;
        this.context = context;
    }

    // extends abstract class ViewHolder
    // A ViewHolder describes an item view and metadata about its place within the RecyclerView
    // Provide a ***reference*** to the views for each data item
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

    //-------------------------------------------------
    // Create new views (ViewHolder) (invoked by the layout manager)
    //-------------------------------------------------
    // This method calls onCreateViewHolder(ViewGroup, int) to create a new RecyclerView.ViewHolder and
    // initializes some private fields to be used by RecyclerView.
    // Called when RecyclerView needs a new RecyclerView.ViewHolder of the given type to represent an item.
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        // create a new item view
        // if data is required to show on new view...
        View mItemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_items_new_ppty, parent, false);

        // set the view's size, margins, paddings and layout parameters
        //...

        // ViewHolder describes an item view and metadata about its place within the RecyclerView.
        // The new ViewHolder will be used to display items of the adapter using onBindViewHolder(ViewHolder, int, List).
        // Since it will be re-used to display different items in the data set,
        // it is a good idea to cache references to sub views of the View to avoid unnecessary findViewById(int) calls.
        ViewHolder mViewHolder = new ViewHolder(mItemView);

        // #onClick: set onclick event to created view
        mItemView.setOnClickListener(this);

        return mViewHolder;
    }

    //---------------------------------------------------------------
    // Replace the contents of a view (invoked by the layout manager)
    //---------------------------------------------------------------
    // Called by RecyclerView to display the data at the specified position.
    // This method should update the contents of the itemView to reflect the item at the given position
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {

        MyNewPptyData myNewPptyData =  mMyNewPptyDataList.get(position);

        mImageLoader = ServerImageParseAdapter.getInstance(context).getImageLoader();

        mImageLoader.get(myNewPptyData.getImageUrlNewPropertySmall(),
                ImageLoader.getImageListener(
                        viewHolder.ImageUrlNewPropertySmallNetworkImageView,//Server Image
                        R.mipmap.ic_launcher,//Before loading server image the default showing image.
                        android.R.drawable.ic_dialog_alert //Error image if requested image dose not found on server.
                )
        );

        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        viewHolder.ImageUrlNewPropertySmallNetworkImageView.setImageUrl(myNewPptyData.getImageUrlNewPropertySmall(), mImageLoader);
        viewHolder.newPropertyNameChiView.setText(myNewPptyData.getNewPropertyNameChi());
        viewHolder.newPropertyNameEngView.setText(myNewPptyData.getNewPropertyNameEng());
        viewHolder.newPropertyAddressView.setText(myNewPptyData.getNewPropertyAddress());

        // #onClick: save data in itemView's tag for data retrieve from click
        viewHolder.itemView.setTag(myNewPptyData);
    }

    //-----------------------------------------------------------------------------------------
    // #onClick: Called when a view has been clicked. Implements interface View.OnClickListener
    //-----------------------------------------------------------------------------------------
    @Override
    public void onClick(View v) {
        if (mOnRecyclerViewItemClickListener != null) {
            //use getTag to get data
            mOnRecyclerViewItemClickListener.onItemClick(v,(MyNewPptyData)v.getTag());
        }
    }

    // #onClick: define interface
    public static interface OnRecyclerViewItemClickListener {
        void onItemClick(View view , MyNewPptyData singleViewData);
    }

    // #onClick:  Revoke from outside: Pg01NewProp > onCreate
    public void setOnItemClickListener(OnRecyclerViewItemClickListener listener) {
        this.mOnRecyclerViewItemClickListener = listener;
    }

    //----------------------------------------------------------------
    // Return the size of your dataset (invoked by the layout manager)
    //----------------------------------------------------------------
    @Override
    public int getItemCount() {
        return mMyNewPptyDataList.size();
    }
}