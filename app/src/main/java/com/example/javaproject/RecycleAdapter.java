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

    public static class ViewHolder extends  RecyclerView.ViewHolder{

        public TextView tName;
        public TextView tLevel;
        public TextView tBindTime;
        public TextView tTimer;
        public TextView tUnbindTime;
        public ImageView team;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tName = itemView.findViewById(R.id.tName);
            tLevel = itemView.findViewById(R.id.tLevel);
            tBindTime = itemView.findViewById(R.id.tTimeBind);
            tTimer = itemView.findViewById(R.id.tTimeleft);
            tUnbindTime = itemView.findViewById(R.id.tTimeUnbind);
        }
    }

    public RecycleAdapter(ArrayList<Character> list) {
        CharList = list;
    }

    @Override
    public ViewHolder  onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycleview, parent, false);
        ViewHolder holder = new ViewHolder(v);
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

    @Override
    public int getItemCount() {
        return CharList.size();
    }
}
