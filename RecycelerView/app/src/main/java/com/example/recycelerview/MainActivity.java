package com.example.recycelerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {


    ViewPager2 viewPager;
    LinearLayoutManager layoutManager;
    MyAdabter myAdabter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager =  findViewById(R.id.rv_cakes);
        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
       // viewPager.setLayoutManager(layoutManager);

        myAdabter = new MyAdabter(this,getCakes());
        viewPager.setAdapter(myAdabter);

        viewPager.setClipToPadding(false);
        viewPager.setClipChildren(false);
        viewPager.setOffscreenPageLimit(3);
        viewPager.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);



    }

    Cakes [] getCakes(){
        Cakes [] cakes = {
                new Cakes(R.drawable.one,"Cake one" , "Cake one desc"),
                new Cakes(R.drawable.two,"Cake two" , "Cake two desc"),
                new Cakes(R.drawable.three,"Cake three" , "Cake three desc"),
                new Cakes(R.drawable.four,"Cake four" , "Cake four desc"),
                new Cakes(R.drawable.five,"Cake five" , "Cake five desc"),
                new Cakes(R.drawable.six,"Cake six" , "Cake six desc"),
                new Cakes(R.drawable.choco_cake_960x960_c_default,"Cake seven" , "Cake seven desc")
        };
        return cakes;
    }
}