package com.example.rotaitioncounter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
      TextView counter;
      int count=0;

      private static final String TAG="increse";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        counter=findViewById(R.id.tv_counetr);
        if(savedInstanceState!=null){
           count=savedInstanceState.getInt(TAG);
            counter.setText(String.valueOf(count));
        }


    }


    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        count++;
        outState.putInt(TAG,count);
    }
}