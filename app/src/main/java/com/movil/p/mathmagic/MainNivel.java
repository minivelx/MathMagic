package com.movil.p.mathmagic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;



public class MainNivel extends AppCompatActivity {

    ViewPager viewPager;
    CustomSwipeAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_nivel);
        viewPager = (ViewPager) findViewById(R.id.view_pager);
        adapter =  new CustomSwipeAdapter(this);
        viewPager.setAdapter(adapter);
    }
}
