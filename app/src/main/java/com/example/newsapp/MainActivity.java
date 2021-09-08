package com.example.newsapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_HIDE_NAVIGATION|
                        View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().setNavigationBarColor(ContextCompat.getColor(this, R.color.idc)); // Navigation bar the soft bottom of some phones like nexus and some Samsung note series
            getWindow().setStatusBarColor(ContextCompat.getColor(this,R.color.idc)); //status bar or the time bar at the top
        }
        FrameLayout recommendedFrame1 = (FrameLayout)findViewById(R.id.recommendedFrame1);
        FrameLayout recommendedFrame2 = (FrameLayout)findViewById(R.id.recommendedFrame2);
        FrameLayout recommendedFrame3 = (FrameLayout)findViewById(R.id.recommendedFrame3);
        FrameLayout HomeIcon = (FrameLayout)findViewById(R.id.HomeIcon);
        FrameLayout DiscoverIcon = (FrameLayout)findViewById(R.id.DiscoverIcon);
        FrameLayout SettingsIcon = (FrameLayout)findViewById(R.id.SettingsIcon);
        TextView otherTextview1 = (TextView)findViewById(R.id.otherTextview1);
        TextView otherTextview2 = (TextView)findViewById(R.id.otherTextview2);
        TextView otherTextview3 = (TextView)findViewById(R.id.otherTextview3);
        TextView otherTextview4 = (TextView)findViewById(R.id.otherTextview4);
        TextView otherTextviewDesc1 = (TextView)findViewById(R.id.otherTextviewDesc1);
        TextView otherTextviewDesc2 = (TextView)findViewById(R.id.otherTextviewDesc2);
        TextView otherTextviewDesc3 = (TextView)findViewById(R.id.otherTextviewDesc3);
        TextView otherTextviewDesc4 = (TextView)findViewById(R.id.otherTextviewDesc4);
        TextView otherTextviewDate1 = (TextView)findViewById(R.id.otherTextviewDate1);
        TextView otherTextviewDate2 = (TextView)findViewById(R.id.otherTextviewDate2);
        TextView otherTextviewDate3 = (TextView)findViewById(R.id.otherTextviewDate3);
        TextView otherTextviewDate4 = (TextView)findViewById(R.id.otherTextviewDate4);
        ImageView otherImage1 = (ImageView)findViewById(R.id.otherImage1);
        ImageView otherImage2 = (ImageView)findViewById(R.id.otherImage2);
        ImageView otherImage3 = (ImageView)findViewById(R.id.otherImage3);
        ImageView otherImage4 = (ImageView)findViewById(R.id.otherImage4);
        CardView otherCard1 = (CardView)findViewById(R.id.otherCard1);
        CardView otherCard2 = (CardView)findViewById(R.id.otherCard2);
        CardView otherCard3 = (CardView)findViewById(R.id.otherCard3);
        CardView otherCard4 = (CardView)findViewById(R.id.otherCard4);
        CardView seeMoreCard = (CardView)findViewById(R.id.seeMoreCard);


        TextView recommendedFirstTextView =(TextView)findViewById(R.id.recommendedFirstTextView);
        ImageView recommendedFirstImageView =(ImageView)findViewById(R.id.recommendedFirstImageView);
        TextView recommendedSecondTextView =(TextView)findViewById(R.id.recommendedSecondTextView);
        ImageView recommendedSecondImageView =(ImageView)findViewById(R.id.recommendedSecondImageView);
        TextView recommendedThirdTextView =(TextView)findViewById(R.id.recommendedThirdTextView);
        ImageView recommendedThirdImageView =(ImageView)findViewById(R.id.recommendedThirdImageView);

        /*HomeIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, MainActivity.class);

                MainActivity.this.startActivity(myIntent);
            }
        });*/

        DiscoverIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, SeeMore.class);

                MainActivity.this.startActivity(myIntent);
            }
        });

        SettingsIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, SettingsPage.class);

                MainActivity.this.startActivity(myIntent);
            }
        });

        recommendedFrame1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, PostBlog.class);
                myIntent.putExtra("PostNumber", 1);
                MainActivity.this.startActivity(myIntent);
            }
        });

        recommendedFrame2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, PostBlog.class);
                myIntent.putExtra("PostNumber", 2);
                MainActivity.this.startActivity(myIntent);
            }
        });

        recommendedFrame3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, PostBlog.class);
                myIntent.putExtra("PostNumber", 3);
                MainActivity.this.startActivity(myIntent);
            }
        });

        otherCard1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, PostBlog.class);
                myIntent.putExtra("PostNumber", 4);
                MainActivity.this.startActivity(myIntent);
            }
        });

        otherCard2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, PostBlog.class);
                myIntent.putExtra("PostNumber", 5);
                MainActivity.this.startActivity(myIntent);
            }
        });

        otherCard3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, PostBlog.class);
                myIntent.putExtra("PostNumber", 6);
                MainActivity.this.startActivity(myIntent);
            }
        });

        otherCard4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, PostBlog.class);
                myIntent.putExtra("PostNumber", 7);
                MainActivity.this.startActivity(myIntent);
            }
        });



        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance("https://teleutaio-test-gamw-default-rtdb.europe-west1.firebasedatabase.app/");

        DatabaseReference posts = database.getReference("Posts");
        DatabaseReference posts1 = posts.child("Post1");
        DatabaseReference posts2 = posts.child("Post2");
        DatabaseReference posts3 = posts.child("Post3");
        DatabaseReference posts4 = posts.child("Post4");
        DatabaseReference posts5 = posts.child("Post5");
        DatabaseReference posts6 = posts.child("Post6");
        DatabaseReference posts7 = posts.child("Post7");
        DatabaseReference image = posts1.child("Image");
        DatabaseReference image2 = posts2.child("Image");
        DatabaseReference image3 = posts3.child("Image");
        DatabaseReference image4 = posts4.child("Image");
        DatabaseReference image5 = posts5.child("Image");
        DatabaseReference image6 = posts6.child("Image");
        DatabaseReference image7 = posts7.child("Image");
        DatabaseReference posts1Title = posts1.child("Title");
        DatabaseReference posts2Title = posts2.child("Title");
        DatabaseReference posts3Title = posts3.child("Title");
        DatabaseReference posts4Title = posts4.child("Title");
        DatabaseReference posts5Title = posts5.child("Title");
        DatabaseReference posts6Title = posts6.child("Title");
        DatabaseReference posts7Title = posts7.child("Title");
        DatabaseReference posts1Description = posts1.child("Description");
        DatabaseReference posts2Description = posts2.child("Description");
        DatabaseReference posts3Description = posts3.child("Description");
        DatabaseReference posts4Description = posts4.child("Description");
        DatabaseReference posts5Description = posts5.child("Description");
        DatabaseReference posts6Description = posts6.child("Description");
        DatabaseReference posts7Description = posts7.child("Description");
        DatabaseReference posts1DescriptionShort = posts1.child("DescriptionShort");
        DatabaseReference posts2DescriptionShort = posts2.child("DescriptionShort");
        DatabaseReference posts3DescriptionShort = posts3.child("DescriptionShort");
        DatabaseReference posts4DescriptionShort = posts4.child("DescriptionShort");
        DatabaseReference posts5DescriptionShort = posts5.child("DescriptionShort");
        DatabaseReference posts6DescriptionShort = posts6.child("DescriptionShort");
        DatabaseReference posts7DescriptionShort = posts7.child("DescriptionShort");
        DatabaseReference posts1Date = posts1.child("Date");
        DatabaseReference posts2Date = posts2.child("Date");
        DatabaseReference posts3Date = posts3.child("Date");
        DatabaseReference posts4Date = posts4.child("Date");
        DatabaseReference posts5Date = posts5.child("Date");
        DatabaseReference posts6Date = posts6.child("Date");
        DatabaseReference posts7Date = posts7.child("Date");


        posts1Title.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue(String.class);
                recommendedFirstTextView.setText("" + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Toast.makeText(getApplicationContext(), "An error occurred please restart app", Toast.LENGTH_LONG).show();

            }
        });

        posts2Title.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue(String.class);
                recommendedSecondTextView.setText("" + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Toast.makeText(getApplicationContext(), "An error occurred please restart app", Toast.LENGTH_LONG).show();

            }
        });

        posts3Title.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue(String.class);
                recommendedThirdTextView.setText("" + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Toast.makeText(getApplicationContext(), "An error occurred please restart app", Toast.LENGTH_LONG).show();

            }
        });

        posts4Title.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue(String.class);
                otherTextview1.setText("" + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Toast.makeText(getApplicationContext(), "An error occurred please restart app", Toast.LENGTH_LONG).show();

            }
        });

        posts5Title.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue(String.class);
                otherTextview2.setText("" + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Toast.makeText(getApplicationContext(), "An error occurred please restart app", Toast.LENGTH_LONG).show();

            }
        });

        posts6Title.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue(String.class);
                otherTextview3.setText("" + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Toast.makeText(getApplicationContext(), "An error occurred please restart app", Toast.LENGTH_LONG).show();

            }
        });

        posts7Title.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue(String.class);
                otherTextview4.setText("" + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Toast.makeText(getApplicationContext(), "An error occurred please restart app", Toast.LENGTH_LONG).show();

            }
        });

        posts4DescriptionShort.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue(String.class);
                otherTextviewDesc1.setText("" + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Toast.makeText(getApplicationContext(), "An error occurred please restart app", Toast.LENGTH_LONG).show();

            }
        });

        posts5DescriptionShort.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue(String.class);
                otherTextviewDesc2.setText("" + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Toast.makeText(getApplicationContext(), "An error occurred please restart app", Toast.LENGTH_LONG).show();

            }
        });

        posts6DescriptionShort.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue(String.class);
                otherTextviewDesc3.setText("" + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Toast.makeText(getApplicationContext(), "An error occurred please restart app", Toast.LENGTH_LONG).show();

            }
        });

        posts7DescriptionShort.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue(String.class);
                otherTextviewDesc4.setText("" + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Toast.makeText(getApplicationContext(), "An error occurred please restart app", Toast.LENGTH_LONG).show();

            }
        });

        posts4Date.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue(String.class);
                otherTextviewDate1.setText("" + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Toast.makeText(getApplicationContext(), "An error occurred please restart app", Toast.LENGTH_LONG).show();

            }
        });

        posts5Date.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue(String.class);
                otherTextviewDate2.setText("" + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Toast.makeText(getApplicationContext(), "An error occurred please restart app", Toast.LENGTH_LONG).show();

            }
        });

        posts6Date.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue(String.class);
                otherTextviewDate3.setText("" + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Toast.makeText(getApplicationContext(), "An error occurred please restart app", Toast.LENGTH_LONG).show();

            }
        });

        posts7Date.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue(String.class);
                otherTextviewDate4.setText("" + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Toast.makeText(getApplicationContext(), "An error occurred please restart app", Toast.LENGTH_LONG).show();

            }
        });

        image.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String link = dataSnapshot.getValue(String.class);
                Picasso.get().load(link).into(recommendedFirstImageView);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Toast.makeText(getApplicationContext(), "An error occurred please restart app", Toast.LENGTH_LONG).show();
            }
        });

        image2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String link = dataSnapshot.getValue(String.class);
                Picasso.get().load(link).into(recommendedSecondImageView);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Toast.makeText(getApplicationContext(), "An error occurred please restart app", Toast.LENGTH_LONG).show();
            }
        });

        image3.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String link = dataSnapshot.getValue(String.class);
                Picasso.get().load(link).into(recommendedThirdImageView);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Toast.makeText(getApplicationContext(), "An error occurred please restart app", Toast.LENGTH_LONG).show();
            }
        });

        image4.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String link = dataSnapshot.getValue(String.class);
                Picasso.get().load(link).into(otherImage1);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Toast.makeText(getApplicationContext(), "An error occurred please restart app", Toast.LENGTH_LONG).show();
            }
        });

        image5.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String link = dataSnapshot.getValue(String.class);
                Picasso.get().load(link).into(otherImage2);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Toast.makeText(getApplicationContext(), "An error occurred please restart app", Toast.LENGTH_LONG).show();
            }
        });

        image6.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String link = dataSnapshot.getValue(String.class);
                Picasso.get().load(link).into(otherImage3);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Toast.makeText(getApplicationContext(), "An error occurred please restart app", Toast.LENGTH_LONG).show();
            }
        });

        image7.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String link = dataSnapshot.getValue(String.class);
                Picasso.get().load(link).into(otherImage4);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Toast.makeText(getApplicationContext(), "An error occurred please restart app", Toast.LENGTH_LONG).show();
            }
        });



        seeMoreCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, SeeMore.class);
                MainActivity.this.startActivity(myIntent);
            }
        });
    }
}