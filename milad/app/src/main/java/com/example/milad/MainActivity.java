package com.example.milad;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.MultiAutoCompleteTextView;
import android.widget.TextView;
import android.widget.VideoView;

import com.bumptech.glide.Glide;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

import java.util.StringTokenizer;

public class MainActivity extends AppCompatActivity {
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
 //   VideoView mealVideo;

YouTubePlayerView youTubePlayerView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

    mealImage = findViewById(R.id.imageView);
    mealName = findViewById(R.id.mealname);
    mealContry =findViewById(R.id.mealContry);
    ingradiant1=findViewById(R.id.ingradiant1);
    ingradiant2=findViewById(R.id.ingradiant2);
        ingradiant3=findViewById(R.id.ingradiant3);
        ingradiant4=findViewById(R.id.ingradiant4);
        ingradiant5=findViewById(R.id.ingradiant5);
        ingradiant6=findViewById(R.id.ingradiant6);
        ingradiant7=findViewById(R.id.ingradiant7);
    steps=findViewById(R.id.steps);


    mealName.setText("Koshary");
    mealContry.setText("Egypt");
    ingradiant1.setText("basl");
        ingradiant2.setText("basl");
        ingradiant3.setText("basl");
        ingradiant4.setText("basl");
        ingradiant5.setText("basl");
        ingradiant6.setText("basl");
        ingradiant7.setText("basl");

        String stepss = "Bring a large pot of water to a boil. Add kosher salt to the boiling water, then add the pasta. Cook according to the package instructions, about 9 minutes.nIn a large skillet over medium-high heat, add the olive oil and heat until the oil starts to shimmer. Add the garlic and cook, stirring, until fragrant, 1 to 2 minutes. Add the chopped tomatoes, red chile flakes, Italian seasoning and salt and pepper to taste. Bring to a boil and cook for 5 minutes. Remove from the heat and add the chopped basil.\\r\\nDrain the pasta and add it to the sauce. Garnish with Parmigiano-Reggiano flakes and more basil and serve warm";


        StringTokenizer tokenizer =new StringTokenizer(stepss,"\\r\\");
        while (tokenizer.hasMoreTokens()) {
             steps.append(tokenizer.nextToken());
        }


        Glide.with(this).load("https://www.themealdb.com/images/category/pasta.png").into(mealImage);





    youTubePlayerView =findViewById(R.id.ybv);
    youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
        @Override
        public void onReady(@NonNull YouTubePlayer youTubePlayer) {
            super.onReady(youTubePlayer);
            youTubePlayer.loadVideo("mulqW-J3Yy4",0);
           // youTubePlayer.play();
        }
    });





    }
}