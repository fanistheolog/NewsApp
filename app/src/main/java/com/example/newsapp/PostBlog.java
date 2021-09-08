package com.example.newsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;

import android.os.Build;
import android.os.Bundle;
import android.view.View;

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
import com.squareup.picasso.Picasso;


public class PostBlog extends AppCompatActivity {
    int viewsNumber= 0;
    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.blog_post);
        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_HIDE_NAVIGATION|
                        View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().setNavigationBarColor(ContextCompat.getColor(this, R.color.idc)); // Navigation bar the soft bottom of some phones like nexus and some Samsung note series
            getWindow().setStatusBarColor(ContextCompat.getColor(this,R.color.idc)); //status bar or the time bar at the top
        }
        ImageView backImage = (ImageView)findViewById(R.id.backImage);
        Intent mIntent = getIntent();
        int PostNumber = mIntent.getIntExtra("PostNumber", 0);
        TextView PostTitleTextView = (TextView)findViewById(R.id.PostTitleTextView);
        TextView RelatedTitleTextView = (TextView)findViewById(R.id.RelatedTitleTextView);
        TextView RelatedTitleTextView2 = (TextView)findViewById(R.id.RelatedTitleTextView2);
        TextView RelatedTitleTextView3 = (TextView)findViewById(R.id.RelatedTitleTextView3);
        TextView RelatedDescriptionTextView = (TextView)findViewById(R.id.RelatedDescriptionTextView);
        TextView RelatedDescriptionTextView2 = (TextView)findViewById(R.id.RelatedDescriptionTextView2);
        TextView RelatedDescriptionTextView3 = (TextView)findViewById(R.id.RelatedDescriptionTextView3);
        TextView RelatedDateTextView = (TextView)findViewById(R.id.RelatedDateTextView);
        TextView RelatedDateTextView2 = (TextView)findViewById(R.id.RelatedDateTextView2);
        TextView RelatedDateTextView3 = (TextView)findViewById(R.id.RelatedDateTextView3);
        TextView PostDescriptionTextView = (TextView)findViewById(R.id.PostDescriptionTextView);
        TextView PostDateTextView = (TextView)findViewById(R.id.postDateTextView);
        TextView PostViewsTextView = (TextView)findViewById(R.id.PostViewsTextView);
        ImageView PostImage = (ImageView)findViewById(R.id.PostImage);
        ImageView RelatedImageView = (ImageView)findViewById(R.id.RelatedImageView);
        ImageView RelatedImageView2 = (ImageView)findViewById(R.id.RelatedImageView2);
        ImageView RelatedImageView3 = (ImageView)findViewById(R.id.RelatedImageView3);
        CardView MoreCommentsCard = (CardView)findViewById(R.id.MoreCommentsCard);
        CardView RelatedCard = (CardView)findViewById(R.id.RelatedCard);
        CardView RelatedCard2 = (CardView)findViewById(R.id.RelatedCard2);
        CardView RelatedCard3 = (CardView)findViewById(R.id.RelatedCard3);
        FrameLayout fullPageFrame =(FrameLayout)findViewById(R.id.fullPageFrame);


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
        DatabaseReference posts1Views = posts1.child("Views");
        DatabaseReference posts2Views = posts2.child("Views");
        DatabaseReference posts3Views = posts3.child("Views");
        DatabaseReference posts4Views = posts4.child("Views");
        DatabaseReference posts5Views = posts5.child("Views");
        DatabaseReference posts6Views = posts6.child("Views");
        DatabaseReference posts7Views = posts7.child("Views");
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


        fullPageFrame.setOnTouchListener(new OnSwipeTouchListener(PostBlog.this) {
            public void onSwipeTop() {

            }
            public void onSwipeRight() {
                Intent myIntent2 = new Intent(PostBlog.this, MainActivity.class);

                PostBlog.this.startActivity(myIntent2);
                overridePendingTransition( R.anim.slide_in_right, R.anim.slide_out_left);



            }
            public void onSwipeLeft() {


            }
            public void onSwipeBottom() {

            }

        });


        if (PostNumber == 1){

            posts1Views.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String value = dataSnapshot.getValue(String.class);
                    viewsNumber = Integer.parseInt(value);
                    viewsNumber++;
                    String string = Integer.toString(viewsNumber);
                    posts1Views.setValue(string);
                    PostViewsTextView.setText("\uD83D\uDC41 " + string );

                }

                @Override
                public void onCancelled(DatabaseError error) {
                    // Failed to read value
                    Toast.makeText(getApplicationContext(), "An error occurred please restart app", Toast.LENGTH_LONG).show();

                }
            });



            posts1Title.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String value = dataSnapshot.getValue(String.class);
                    PostTitleTextView.setText("" + value);
                }

                @Override
                public void onCancelled(DatabaseError error) {
                    // Failed to read value
                    Toast.makeText(getApplicationContext(), "An error occurred please restart app", Toast.LENGTH_LONG).show();

                }
            });

            posts1Description.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String value = dataSnapshot.getValue(String.class);
                    PostDescriptionTextView.setText("" + value);
                }

                @Override
                public void onCancelled(DatabaseError error) {
                    // Failed to read value
                    Toast.makeText(getApplicationContext(), "An error occurred please restart app", Toast.LENGTH_LONG).show();

                }
            });

            posts1Date.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String value = dataSnapshot.getValue(String.class);
                    PostDateTextView.setText("" + value);
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
                    Picasso.get().load(link).into(PostImage);
                }

                @Override
                public void onCancelled(DatabaseError error) {
                    // Failed to read value
                    Toast.makeText(getApplicationContext(), "An error occurred please restart app", Toast.LENGTH_LONG).show();
                }
            });

        }

        if (PostNumber == 2){
            posts2Views.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String value = dataSnapshot.getValue(String.class);
                    viewsNumber = Integer.parseInt(value);
                    viewsNumber++;
                    String string = Integer.toString(viewsNumber);
                    posts2Views.setValue(string);
                    PostViewsTextView.setText("\uD83D\uDC41 " + string );

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
                    PostTitleTextView.setText("" + value);
                }

                @Override
                public void onCancelled(DatabaseError error) {
                    // Failed to read value
                    Toast.makeText(getApplicationContext(), "An error occurred please restart app", Toast.LENGTH_LONG).show();

                }
            });

            posts2Description.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String value = dataSnapshot.getValue(String.class);
                    PostDescriptionTextView.setText("" + value);
                }

                @Override
                public void onCancelled(DatabaseError error) {
                    // Failed to read value
                    Toast.makeText(getApplicationContext(), "An error occurred please restart app", Toast.LENGTH_LONG).show();

                }
            });

            posts2Date.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String value = dataSnapshot.getValue(String.class);
                    PostDateTextView.setText("" + value);
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
                    Picasso.get().load(link).into(PostImage);
                }

                @Override
                public void onCancelled(DatabaseError error) {
                    // Failed to read value
                    Toast.makeText(getApplicationContext(), "An error occurred please restart app", Toast.LENGTH_LONG).show();
                }
            });

        }

        if (PostNumber == 3){
            posts3Views.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String value = dataSnapshot.getValue(String.class);
                    viewsNumber = Integer.parseInt(value);
                    viewsNumber++;
                    String string = Integer.toString(viewsNumber);
                    posts3Views.setValue(string);
                    PostViewsTextView.setText("\uD83D\uDC41 " + string );

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
                    PostTitleTextView.setText("" + value);
                }

                @Override
                public void onCancelled(DatabaseError error) {
                    // Failed to read value
                    Toast.makeText(getApplicationContext(), "An error occurred please restart app", Toast.LENGTH_LONG).show();

                }
            });

            posts3Description.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String value = dataSnapshot.getValue(String.class);
                    PostDescriptionTextView.setText("" + value);
                }

                @Override
                public void onCancelled(DatabaseError error) {
                    // Failed to read value
                    Toast.makeText(getApplicationContext(), "An error occurred please restart app", Toast.LENGTH_LONG).show();

                }
            });

            posts3Date.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String value = dataSnapshot.getValue(String.class);
                    PostDateTextView.setText("" + value);
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
                    Picasso.get().load(link).into(PostImage);
                }

                @Override
                public void onCancelled(DatabaseError error) {
                    // Failed to read value
                    Toast.makeText(getApplicationContext(), "An error occurred please restart app", Toast.LENGTH_LONG).show();
                }
            });

        }

        if (PostNumber == 4){

            posts4Views.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String value = dataSnapshot.getValue(String.class);
                    viewsNumber = Integer.parseInt(value);
                    viewsNumber++;
                    String string = Integer.toString(viewsNumber);
                    posts4Views.setValue(string);
                    PostViewsTextView.setText("\uD83D\uDC41 " + string );

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
                    PostTitleTextView.setText("" + value);
                }

                @Override
                public void onCancelled(DatabaseError error) {
                    // Failed to read value
                    Toast.makeText(getApplicationContext(), "An error occurred please restart app", Toast.LENGTH_LONG).show();

                }
            });

            posts4Description.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String value = dataSnapshot.getValue(String.class);
                    PostDescriptionTextView.setText("" + value);
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
                    PostDateTextView.setText("" + value);
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
                    Picasso.get().load(link).into(PostImage);
                }

                @Override
                public void onCancelled(DatabaseError error) {
                    // Failed to read value
                    Toast.makeText(getApplicationContext(), "An error occurred please restart app", Toast.LENGTH_LONG).show();
                }
            });

        }

        if (PostNumber == 5){
            posts5Views.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String value = dataSnapshot.getValue(String.class);
                    viewsNumber = Integer.parseInt(value);
                    viewsNumber++;
                    String string = Integer.toString(viewsNumber);
                    posts5Views.setValue(string);
                    PostViewsTextView.setText("\uD83D\uDC41 " + string );

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
                    PostTitleTextView.setText("" + value);
                }

                @Override
                public void onCancelled(DatabaseError error) {
                    // Failed to read value
                    Toast.makeText(getApplicationContext(), "An error occurred please restart app", Toast.LENGTH_LONG).show();

                }
            });

            posts5Description.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String value = dataSnapshot.getValue(String.class);
                    PostDescriptionTextView.setText("" + value);
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
                    PostDateTextView.setText("" + value);
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
                    Picasso.get().load(link).into(PostImage);
                }

                @Override
                public void onCancelled(DatabaseError error) {
                    // Failed to read value
                    Toast.makeText(getApplicationContext(), "An error occurred please restart app", Toast.LENGTH_LONG).show();
                }
            });

        }

        if (PostNumber == 6){
            posts6Views.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String value = dataSnapshot.getValue(String.class);
                    viewsNumber = Integer.parseInt(value);
                    viewsNumber++;
                    String string = Integer.toString(viewsNumber);
                    posts6Views.setValue(string);
                    PostViewsTextView.setText("\uD83D\uDC41 " + string );

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
                    PostTitleTextView.setText("" + value);
                }

                @Override
                public void onCancelled(DatabaseError error) {
                    // Failed to read value
                    Toast.makeText(getApplicationContext(), "An error occurred please restart app", Toast.LENGTH_LONG).show();

                }
            });

            posts6Description.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String value = dataSnapshot.getValue(String.class);
                    PostDescriptionTextView.setText("" + value);
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
                    PostDateTextView.setText("" + value);
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
                    Picasso.get().load(link).into(PostImage);
                }

                @Override
                public void onCancelled(DatabaseError error) {
                    // Failed to read value
                    Toast.makeText(getApplicationContext(), "An error occurred please restart app", Toast.LENGTH_LONG).show();
                }
            });

        }

        if (PostNumber == 7){
            posts7Views.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String value = dataSnapshot.getValue(String.class);
                    viewsNumber = Integer.parseInt(value);
                    viewsNumber++;
                    String string = Integer.toString(viewsNumber);
                    posts7Views.setValue(string);
                    PostViewsTextView.setText("\uD83D\uDC41 " + string );

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
                    PostTitleTextView.setText("" + value);
                }

                @Override
                public void onCancelled(DatabaseError error) {
                    // Failed to read value
                    Toast.makeText(getApplicationContext(), "An error occurred please restart app", Toast.LENGTH_LONG).show();

                }
            });

            posts7Description.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String value = dataSnapshot.getValue(String.class);
                    PostDescriptionTextView.setText("" + value);
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
                    PostDateTextView.setText("" + value);
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
                    Picasso.get().load(link).into(PostImage);
                }

                @Override
                public void onCancelled(DatabaseError error) {
                    // Failed to read value
                    Toast.makeText(getApplicationContext(), "An error occurred please restart app", Toast.LENGTH_LONG).show();
                }
            });

        }

        if (PostNumber== 1 || PostNumber== 2 || PostNumber== 3 || PostNumber== 4) {
            RelatedCard.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent myIntent = new Intent(PostBlog.this, PostBlog.class);
                    myIntent.putExtra("PostNumber", 5);
                    PostBlog.this.startActivity(myIntent);
                }
            });

            RelatedCard2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent myIntent = new Intent(PostBlog.this, PostBlog.class);
                    myIntent.putExtra("PostNumber", 6);
                    PostBlog.this.startActivity(myIntent);
                }
            });

            RelatedCard3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent myIntent = new Intent(PostBlog.this, PostBlog.class);
                    myIntent.putExtra("PostNumber", 7);
                    PostBlog.this.startActivity(myIntent);
                }
            });

            MoreCommentsCard.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent myIntent = new Intent(PostBlog.this, CommentsPage.class);
                    myIntent.putExtra("PostNumber", PostNumber);
                    PostBlog.this.startActivity(myIntent);
                }
            });



            posts5Title.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String value = dataSnapshot.getValue(String.class);
                    RelatedTitleTextView.setText("" + value);
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
                    RelatedDateTextView.setText("" + value);
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
                    RelatedDescriptionTextView.setText("" + value);
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
                    Picasso.get().load(link).into(RelatedImageView);
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
                    RelatedTitleTextView2.setText("" + value);
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
                    RelatedDateTextView2.setText("" + value);
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
                    RelatedDescriptionTextView2.setText("" + value);
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
                    Picasso.get().load(link).into(RelatedImageView2);
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
                    RelatedTitleTextView3.setText("" + value);
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
                    RelatedDateTextView3.setText("" + value);
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
                    RelatedDescriptionTextView3.setText("" + value);
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
                    Picasso.get().load(link).into(RelatedImageView3);
                }

                @Override
                public void onCancelled(DatabaseError error) {
                    // Failed to read value
                    Toast.makeText(getApplicationContext(), "An error occurred please restart app", Toast.LENGTH_LONG).show();
                }
            });

        }

        if (PostNumber == 5){

            RelatedCard.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent myIntent = new Intent(PostBlog.this, PostBlog.class);
                    myIntent.putExtra("PostNumber", 4);
                    PostBlog.this.startActivity(myIntent);
                }
            });

            RelatedCard2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent myIntent = new Intent(PostBlog.this, PostBlog.class);
                    myIntent.putExtra("PostNumber", 6);
                    PostBlog.this.startActivity(myIntent);
                }
            });

            RelatedCard3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent myIntent = new Intent(PostBlog.this, PostBlog.class);
                    myIntent.putExtra("PostNumber", 7);
                    PostBlog.this.startActivity(myIntent);
                }
            });

            MoreCommentsCard.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent myIntent = new Intent(PostBlog.this, CommentsPage.class);
                    myIntent.putExtra("PostNumber", PostNumber);
                    PostBlog.this.startActivity(myIntent);
                }
            });

            posts4Title.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String value = dataSnapshot.getValue(String.class);
                    RelatedTitleTextView.setText("" + value);
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
                    RelatedDateTextView.setText("" + value);
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
                    RelatedDescriptionTextView.setText("" + value);
                }

                @Override
                public void onCancelled(DatabaseError error) {
                    // Failed to read value
                    Toast.makeText(getApplicationContext(), "An error occurred please restart app", Toast.LENGTH_LONG).show();

                }
            });

            image4.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String link = dataSnapshot.getValue(String.class);
                    Picasso.get().load(link).into(RelatedImageView);
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
                    RelatedTitleTextView2.setText("" + value);
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
                    RelatedDateTextView2.setText("" + value);
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
                    RelatedDescriptionTextView2.setText("" + value);
                }

                @Override
                public void onCancelled(DatabaseError error) {
                    // Failed to read value
                    Toast.makeText(getApplicationContext(), "An error occurred please restart app", Toast.LENGTH_LONG).show();

                }
            });

            image6.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String link = dataSnapshot.getValue(String.class);
                    Picasso.get().load(link).into(RelatedImageView2);
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
                    RelatedTitleTextView3.setText("" + value);
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
                    RelatedDateTextView3.setText("" + value);
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
                    RelatedDescriptionTextView3.setText("" + value);
                }

                @Override
                public void onCancelled(DatabaseError error) {
                    // Failed to read value
                    Toast.makeText(getApplicationContext(), "An error occurred please restart app", Toast.LENGTH_LONG).show();

                }
            });

            image7.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String link = dataSnapshot.getValue(String.class);
                    Picasso.get().load(link).into(RelatedImageView3);
                }

                @Override
                public void onCancelled(DatabaseError error) {
                    // Failed to read value
                    Toast.makeText(getApplicationContext(), "An error occurred please restart app", Toast.LENGTH_LONG).show();
                }
            });
        }

        if (PostNumber == 6){
            RelatedCard.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent myIntent = new Intent(PostBlog.this, PostBlog.class);
                    myIntent.putExtra("PostNumber", 4);
                    PostBlog.this.startActivity(myIntent);
                }
            });

            RelatedCard2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent myIntent = new Intent(PostBlog.this, PostBlog.class);
                    myIntent.putExtra("PostNumber", 5);
                    PostBlog.this.startActivity(myIntent);
                }
            });

            RelatedCard3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent myIntent = new Intent(PostBlog.this, PostBlog.class);
                    myIntent.putExtra("PostNumber", 7);
                    PostBlog.this.startActivity(myIntent);
                }
            });

            MoreCommentsCard.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent myIntent = new Intent(PostBlog.this, CommentsPage.class);
                    myIntent.putExtra("PostNumber", PostNumber);
                    PostBlog.this.startActivity(myIntent);
                }
            });

            posts4Title.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String value = dataSnapshot.getValue(String.class);
                    RelatedTitleTextView.setText("" + value);
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
                    RelatedDateTextView.setText("" + value);
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
                    RelatedDescriptionTextView.setText("" + value);
                }

                @Override
                public void onCancelled(DatabaseError error) {
                    // Failed to read value
                    Toast.makeText(getApplicationContext(), "An error occurred please restart app", Toast.LENGTH_LONG).show();

                }
            });

            image4.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String link = dataSnapshot.getValue(String.class);
                    Picasso.get().load(link).into(RelatedImageView);
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
                    RelatedTitleTextView2.setText("" + value);
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
                    RelatedDateTextView2.setText("" + value);
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
                    RelatedDescriptionTextView2.setText("" + value);
                }

                @Override
                public void onCancelled(DatabaseError error) {
                    // Failed to read value
                    Toast.makeText(getApplicationContext(), "An error occurred please restart app", Toast.LENGTH_LONG).show();

                }
            });

            image5.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String link = dataSnapshot.getValue(String.class);
                    Picasso.get().load(link).into(RelatedImageView2);
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
                    RelatedTitleTextView3.setText("" + value);
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
                    RelatedDateTextView3.setText("" + value);
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
                    RelatedDescriptionTextView3.setText("" + value);
                }

                @Override
                public void onCancelled(DatabaseError error) {
                    // Failed to read value
                    Toast.makeText(getApplicationContext(), "An error occurred please restart app", Toast.LENGTH_LONG).show();

                }
            });

            image7.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String link = dataSnapshot.getValue(String.class);
                    Picasso.get().load(link).into(RelatedImageView3);
                }

                @Override
                public void onCancelled(DatabaseError error) {
                    // Failed to read value
                    Toast.makeText(getApplicationContext(), "An error occurred please restart app", Toast.LENGTH_LONG).show();
                }
            });
        }

        if (PostNumber == 7){

            RelatedCard.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent myIntent = new Intent(PostBlog.this, PostBlog.class);
                    myIntent.putExtra("PostNumber", 4);
                    PostBlog.this.startActivity(myIntent);
                }
            });

            RelatedCard2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent myIntent = new Intent(PostBlog.this, PostBlog.class);
                    myIntent.putExtra("PostNumber", 5);
                    PostBlog.this.startActivity(myIntent);
                }
            });

            RelatedCard3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent myIntent = new Intent(PostBlog.this, PostBlog.class);
                    myIntent.putExtra("PostNumber", 6);
                    PostBlog.this.startActivity(myIntent);
                }
            });

            MoreCommentsCard.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent myIntent = new Intent(PostBlog.this, CommentsPage.class);
                    myIntent.putExtra("PostNumber", PostNumber);
                    PostBlog.this.startActivity(myIntent);
                }
            });

            posts4Title.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String value = dataSnapshot.getValue(String.class);
                    RelatedTitleTextView.setText("" + value);
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
                    RelatedDateTextView.setText("" + value);
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
                    RelatedDescriptionTextView.setText("" + value);
                }

                @Override
                public void onCancelled(DatabaseError error) {
                    // Failed to read value
                    Toast.makeText(getApplicationContext(), "An error occurred please restart app", Toast.LENGTH_LONG).show();

                }
            });

            image4.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String link = dataSnapshot.getValue(String.class);
                    Picasso.get().load(link).into(RelatedImageView);
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
                    RelatedTitleTextView2.setText("" + value);
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
                    RelatedDateTextView2.setText("" + value);
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
                    RelatedDescriptionTextView2.setText("" + value);
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
                    Picasso.get().load(link).into(RelatedImageView2);
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
                    RelatedTitleTextView3.setText("" + value);
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
                    RelatedDateTextView3.setText("" + value);
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
                    RelatedDescriptionTextView3.setText("" + value);
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
                    Picasso.get().load(link).into(RelatedImageView3);
                }

                @Override
                public void onCancelled(DatabaseError error) {
                    // Failed to read value
                    Toast.makeText(getApplicationContext(), "An error occurred please restart app", Toast.LENGTH_LONG).show();
                }
            });
        }




        backImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(PostBlog.this, MainActivity.class);

                PostBlog.this.startActivity(myIntent);
            }
        });

    }
}