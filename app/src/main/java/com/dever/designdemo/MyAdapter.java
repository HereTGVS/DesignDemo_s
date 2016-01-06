package com.dever.designdemo;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.design.widget.SwipeDismissBehavior;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Android Studio
 * Time: 2016/1/6 11:26
 * Author: wangmeng
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> implements SwipeDismissBehavior.OnDismissListener {

    private Context context;
    private List<String> list;
    private CoordinatorLayout item_coor;
    private RecyclerView recyclerView;

    public MyAdapter(Context context, List<String> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=null;
        view = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
        item_coor = (CoordinatorLayout) view.findViewById(R.id.item_coor);
        MyViewHolder holder = new MyViewHolder(view);
        CoordinatorLayout.LayoutParams params = (CoordinatorLayout.LayoutParams) holder.text.getLayoutParams();
        SwipeDismissBehavior behavior = new SwipeDismissBehavior();
        behavior.setListener(this);
        params.setBehavior(behavior);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.text.setText(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        this.recyclerView = recyclerView;
    }

    @Override
    public void onDismiss(final View view) {
        final View parent = (View) view.getParent();
        final int position = recyclerView.getChildAdapterPosition(parent);
        final String remove = list.remove(position);
        notifyItemRangeRemoved(position,list.size());
        view.setAlpha(1);
        Snackbar.make((View) recyclerView.getParent(),"确定要删除“"+remove+"”吗？",Snackbar.LENGTH_INDEFINITE).setAction("撤销", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list.add(position,remove);
                notifyItemInserted(position);
                view.setAlpha(1);
            }
        }).show();
    }

    @Override
    public void onDragStateChanged(int state) {

    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView text;

        public MyViewHolder(View itemView) {
            super(itemView);
            text = (TextView)itemView.findViewById(R.id.item_text);
        }
    }
}
