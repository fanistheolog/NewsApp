package com.example.newsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;


import android.content.Intent;
import android.graphics.Color;

import android.os.Build;
import android.os.Bundle;
import android.view.View;

import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;


public class SeeMore extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.more_see);
        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_HIDE_NAVIGATION|
                        View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().setNavigationBarColor(ContextCompat.getColor(this, R.color.idc)); // Navigation bar the soft bottom of some phones like nexus and some Samsung note series
            getWindow().setStatusBarColor(ContextCompat.getColor(this,R.color.idc)); //status bar or the time bar at the top
        }
        ImageView backImage = (ImageView)findViewById(R.id.backImage2);
        backImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(SeeMore.this, MainActivity.class);

                SeeMore.this.startActivity(myIntent);
            }
            });
        FrameLayout HomeIcon = (FrameLayout)findViewById(R.id.HomeIcon);
        FrameLayout DiscoverIcon = (FrameLayout)findViewById(R.id.DiscoverIcon);
        FrameLayout SettingsIcon = (FrameLayout)findViewById(R.id.SettingsIcon);
        HomeIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(SeeMore.this, MainActivity.class);

                SeeMore.this.startActivity(myIntent);
            }
        });

        /*DiscoverIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(SeeMore.this, SeeMore.class);

                SeeMore.this.startActivity(myIntent);
            }
        });*/

        SettingsIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(SeeMore.this, SettingsPage.class);

                SeeMore.this.startActivity(myIntent);
            }
        });


    }
}