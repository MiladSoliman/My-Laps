package com.example.mvc_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.mvc_project.allproducts.controller.AllProductsActivity;
import com.example.mvc_project.favproducts.controller.FavProductsActivity;

public class MainActivity extends AppCompatActivity {

    Button btAll ;
    Button btFav ;
    Button btEnd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btAll = findViewById(R.id.btn_allproudcts);
        btFav = findViewById(R.id.btn_favProduct);
        btEnd = findViewById(R.id.btn_finish);


        btAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AllProductsActivity.class);
                startActivity(intent);
            }
        });

        btFav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FavProductsActivity.class);
                startActivity(intent);
            }
        });



        btEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}