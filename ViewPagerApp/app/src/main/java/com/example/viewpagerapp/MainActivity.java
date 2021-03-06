package com.example.viewpagerapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ViewPager2 vPager;
    ArrayList<String> number = new ArrayList<>();
    ArrayList<DisplayMetrics> metricsList = new ArrayList<>();
    ViewPagerAdapter mAdapter;
    int numberOfPage = 0;
//    int currentPage;
    DisplayMetrics metrics;
    TextView textView;
//    Button nextPage, prevPage;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vPager = findViewById(R.id.pager);
        textView = findViewById(R.id.textAt0);
//        nextPage = findViewById(R.id.next_page);
//        prevPage = findViewById(R.id.previous_page);
        vPager.setUserInputEnabled(false);

//        nextPage.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                currentPage = vPager.getCurrentItem();
//                vPager.setCurrentItem(currentPage+1, true);
//            }
//        });
//        prevPage.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                currentPage = vPager.getCurrentItem();
//                vPager.setCurrentItem(currentPage-1, true);
//            }
//        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.add_page) {
            if (numberOfPage == 0){
                textView.setVisibility(View.INVISIBLE);
            }
            numberOfPage++;
            number.add(String.valueOf(numberOfPage));
            metrics = new DisplayMetrics();
            getWindowManager().getDefaultDisplay().getMetrics(metrics);
            metricsList.add(metrics);
            mAdapter = new ViewPagerAdapter(number, metricsList,vPager);
            vPager.setAdapter(mAdapter);
            return true;
        } else if (id == R.id.remove_page){
            if (numberOfPage > 0) {
                number.remove(String.valueOf(numberOfPage));
                numberOfPage--;
                metricsList.remove(metrics);
                mAdapter = new ViewPagerAdapter(number, metricsList, vPager);
                vPager.setAdapter(mAdapter);
            }
            if (numberOfPage == 0){
                textView.setVisibility(View.VISIBLE);
                Toast.makeText(MainActivity.this, "Number of pages are 0. Add a page.", Toast.LENGTH_SHORT).show();
            }
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}