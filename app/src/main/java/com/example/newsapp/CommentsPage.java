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
import android.widget.ImageView;

import com.example.newsapp.MainActivity;
import com.example.newsapp.R;


public class CommentsPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_comments);
        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_HIDE_NAVIGATION|
                        View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().setNavigationBarColor(ContextCompat.getColor(this, R.color.idc)); // Navigation bar the soft bottom of some phones like nexus and some Samsung note series
            getWindow().setStatusBarColor(ContextCompat.getColor(this,R.color.idc)); //status bar or the time bar at the top
        }
        Intent mIntent = getIntent();
        int PostNumber = mIntent.getIntExtra("PostNumber", 0);

        ImageView backImage3 = (ImageView)findViewById(R.id.backImage3);
        backImage3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(CommentsPage.this, PostBlog.class);
                myIntent.putExtra("PostNumber", PostNumber);
                CommentsPage.this.startActivity(myIntent);
            }
        });



    }
}