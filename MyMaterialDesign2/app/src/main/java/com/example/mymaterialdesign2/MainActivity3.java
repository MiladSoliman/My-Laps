package com.example.mymaterialdesign2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import com.bumptech.glide.Glide;

public class MainActivity3 extends AppCompatActivity {
    ImageView mealImage;
    TextView mealName;
    TextView mealContry;
    TextView mealIngradiant;
    TextView ingradiant1;
    TextView ingradiant2;
    TextView ingradiant3;
    TextView ingradiant4;
    TextView ingradiant5;
    TextView ingradiant6;
    TextView ingradiant7;
    TextView steps;
    VideoView mealVideo;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      //  setContentView(R.layout.activity_main3);

        mealImage=findViewById(R.id.imageView2);
        mealName=findViewById(R.id.textView5);
        mealContry=findViewById(R.id.textView6);
        ingradiant1=findViewById(R.id.textView8);
        ingradiant2=findViewById(R.id.textView9);
        ingradiant3=findViewById(R.id.textView10);
        ingradiant4=findViewById(R.id.textView11);
        ingradiant5=findViewById(R.id.textView12);
        ingradiant6 = findViewById(R.id.textView13);
        ingradiant7=findViewById(R.id.textView14);
        steps=findViewById(R.id.tv_steps);
        mealVideo =findViewById(R.id.videoView);


        mealName.setText("Pasta");
        mealContry.setText("Egypt");
        ingradiant1.setText("basl");
        ingradiant2.setText("basl");
        ingradiant3.setText("basl");
        ingradiant4.setText("basl");
        ingradiant5.setText("basl");
        ingradiant6.setText("basl");
        ingradiant7.setText("basl");

        steps.setText("Lionel Andrés Messi[note 1] (Spanish pronunciation: [ljoˈnel anˈdɾes ˈmesi] (listen); born 24 June 1987), also known as Leo Messi, is an Argentine professional footballer who plays as a forward for Ligue 1 club Paris Saint-Germain and captains the Argentina national team. Widely regarded as one of the greatest players of all time, Messi has won a record seven Ballon d'Or awards,[note 2] a record six European Golden Shoes, and in 2020 was named to the Ballon d'Or Dream Team. Until leaving the club in 2021, he had spent his entire professional career with Barcelona, where he won a club-record 35 trophies, including 10 La Liga titles, seven Copa del Rey titles and four UEFA Champions Leagues. With his country, he won the 2021 Copa América and the 2022 FIFA World Cup. A prolific goalscorer and creative playmaker, Messi holds the records for most goals in La Liga (474), most hat-tricks in La Liga (36) and the UEFA Champions League (8), and most assists in La Liga (192) and the Copa América (17). He has also the most international goals by a South American male (98). Messi has scored over 795 senior career goals for club and country, and has the most goals by a player for a single club (672).");

        Glide.with(this).load("https://www.themealdb.com/images/category/pasta.png").into(mealImage);
        mealVideo.setVideoPath("https://www.youtube.com/watch?v=h6g4NpiC0i4");
        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(mealVideo);
        mealVideo.setMediaController(mediaController);
        mealVideo.start();








    }
}