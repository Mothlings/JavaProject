package com.example.javaproject;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.ArrayList;

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.ViewHolder> {
    private ArrayList<Character> CharList;
    private OnItemListener mOnItemListener;


    public static class ViewHolder extends  RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView tName;
        public TextView tLevel;
        public TextView tBindTime;
        public TextView tTimer;
        public TextView tUnbindTime;
        public ImageView team;
        private OnItemListener onItemListener;

        public ViewHolder(@NonNull View itemView, OnItemListener onItemListener) {
            super(itemView);
            tName = itemView.findViewById(R.id.tName);
            tLevel = itemView.findViewById(R.id.tLevel);
            tBindTime = itemView.findViewById(R.id.tTimeBind);
            tTimer = itemView.findViewById(R.id.tTimeleft);
            tUnbindTime = itemView.findViewById(R.id.tTimeUnbind);
            this.onItemListener =onItemListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onItemListener.onItemClick(getAdapterPosition());
        }
    }

    public RecycleAdapter(ArrayList<Character> list, OnItemListener onItemListener) {
        this.CharList = list;
        this.mOnItemListener = onItemListener;
    }

    @Override
    public ViewHolder  onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycleview, parent, false);
        ViewHolder holder = new ViewHolder(v, mOnItemListener );
        return holder;
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Character currentItem = CharList.get(position);
        holder.tName.setText("Name: "+currentItem.getName());
        holder.tLevel.setText("Level: "+currentItem.getLevel());
        holder.tBindTime.setText("Bind time: "+currentItem.getStartTime());
        holder.tUnbindTime.setText("Unbind time: "+currentItem.getEndTime());
    }

    public interface OnItemListener{
        void onItemClick(int position);
    }

    @Override
    public int getItemCount() {
        return CharList.size();
    }
}
