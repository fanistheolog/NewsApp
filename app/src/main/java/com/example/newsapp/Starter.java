package com.example.newsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;


import android.content.Intent;
import android.graphics.Color;

import android.os.Bundle;
import android.view.View;

import android.view.WindowManager;
import android.widget.ImageView;


public class Starter extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.starter_layout);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,

                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_HIDE_NAVIGATION|
                        View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        CardView loginCard = (CardView)findViewById(R.id.loginCard);
        CardView signUpCard = (CardView)findViewById(R.id.signUpCard);
        loginCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(Starter.this, MainActivity.class);

                Starter.this.startActivity(myIntent);
            }
        });
        signUpCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(Starter.this, MainActivity.class);

                Starter.this.startActivity(myIntent);
            }
        });

    }
}