package com.fcm.firsthandpptynoti.adapter;

/**
 * Created by joelau on 31/8/16.
 */

import android.content.Context;
        import android.support.v7.widget.RecyclerView;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.FrameLayout;
        import android.widget.TextView;
        import java.util.List;
        import android.view.ViewGroup.LayoutParams;

import com.fcm.firsthandpptynoti.R;

/**
 * Created by Moon on 2015/11/21.
 */
public class MyRecyclerViewAdapterAllPush extends RecyclerView.Adapter<MyRecyclerViewAdapterAllPush.MyViewHolder>
{
    private List<String> mList;
    private Context mContext;;
    private OnItemClickListener mOnItemClickListener;
    public MyRecyclerViewAdapterAllPush(Context mContext,List<String>mList){
        this.mContext=mContext;
        this.mList=mList;
    }
    public interface OnItemClickListener
    {
        void onItemClick(View view, int position);
        void onItemLongClick(View view,int position);

    }

    public void setOnItemClickListener(OnItemClickListener mOnItemClickListener)
    {
        this.mOnItemClickListener = mOnItemClickListener;
    }

    public void removeData(int position) {
        mList.remove(position);
        notifyItemRemoved(position);
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        MyViewHolder holder = new MyViewHolder(LayoutInflater.from(
                mContext).inflate(R.layout.recyclerview_items_tab02_allpush, parent,
                false));
        return holder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position)
    {
//        LayoutParams lp = holder.tv.getLayoutParams();
//        lp.height =400;
//        holder.tv.setLayoutParams(lp);
        holder.tv.setText(mList.get(position));
        if (mOnItemClickListener != null)
        {
            holder.tv.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    int pos = holder.getLayoutPosition();
                    mOnItemClickListener.onItemClick(holder.tv,pos);
                }
            });
            holder.tv.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    int pos = holder.getLayoutPosition();
                    mOnItemClickListener.onItemLongClick(holder.tv,pos);
                    return false;
                }
            });
        }
    }

    @Override
    public int getItemCount()
    {
        return mList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder
    {

        TextView tv;
        public MyViewHolder(View view)
        {
            super(view);
            tv = (TextView) view.findViewById(R.id.item_tab02_allpush);
        }
    }
}
