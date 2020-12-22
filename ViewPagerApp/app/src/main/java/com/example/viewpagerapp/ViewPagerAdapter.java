package com.example.viewpagerapp;

import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;

public class ViewPagerAdapter extends RecyclerView.Adapter<ViewPagerAdapter.ViewHolder> {

    ArrayList<String> number;
    ArrayList<DisplayMetrics> metricsList;
    String dec;
    ViewPager2 viewPager2;
    public ViewPagerAdapter(ArrayList<String> numPage, ArrayList<DisplayMetrics> metricsList, ViewPager2 viewPager2){
        this.number = numPage;
        this.metricsList = metricsList;
        this.viewPager2 = viewPager2;
    }

    @NonNull
    @Override
    public ViewPagerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_main, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewPagerAdapter.ViewHolder holder, int position) {
        holder.nextPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager2.setCurrentItem(viewPager2.getCurrentItem()+1, true);
            }
        });
        holder.prevPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager2.setCurrentItem(viewPager2.getCurrentItem()-1, true);
            }
        });
        holder.pageNumber.setText(number.get(position));
        dec = number.get(position) + "/" + number.size();
        holder.pageNum.setText(dec);
        holder.paintView.init(metricsList.get(position));
    }

    @Override
    public int getItemCount() {
        return number.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        TextView pageNumber, pageNum;
        PaintView paintView;
        Button nextPage, prevPage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nextPage = itemView.findViewById(R.id.next_page);
            prevPage = itemView.findViewById(R.id.previous_page);
            pageNumber = itemView.findViewById(R.id.number_page);
            pageNum = itemView.findViewById(R.id.page_num);
            paintView = itemView.findViewById(R.id.paintView);
        }
    }
}
