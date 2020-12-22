package com.example.viewpagerapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ViewPagerAdapter extends RecyclerView.Adapter<ViewPagerAdapter.ViewHolder> {

    ArrayList<String> number;
    String dec;
    public ViewPagerAdapter(ArrayList<String> numPage){
        this.number = numPage;
    }

    @NonNull
    @Override
    public ViewPagerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_main, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewPagerAdapter.ViewHolder holder, int position) {
        holder.pageNumber.setText(number.get(position));
        dec = number.get(position) + "/" + number.size();
        holder.pageNum.setText(dec);
    }

    @Override
    public int getItemCount() {
        return number.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        TextView pageNumber, pageNum;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            pageNumber = itemView.findViewById(R.id.number_page);
            pageNum = itemView.findViewById(R.id.page_num);
        }
    }
}
