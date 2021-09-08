package com.example.newsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;


import android.content.Intent;
import android.graphics.Color;

import android.os.Bundle;
import android.view.View;

import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;


public class SettingsPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_settings);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,

                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_HIDE_NAVIGATION|
                        View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        FrameLayout HomeIcon = (FrameLayout)findViewById(R.id.HomeIcon);
        FrameLayout DiscoverIcon = (FrameLayout)findViewById(R.id.DiscoverIcon);
        FrameLayout SettingsIcon = (FrameLayout)findViewById(R.id.SettingsIcon);

        HomeIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(SettingsPage.this, MainActivity.class);

                SettingsPage.this.startActivity(myIntent);
            }
        });

        DiscoverIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(SettingsPage.this, SeeMore.class);

                SettingsPage.this.startActivity(myIntent);
            }
        });

        /*SettingsIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(SettingsPage.this, SettingsPage.class);

                SettingsPage.this.startActivity(myIntent);
            }
        });*/

    }
}