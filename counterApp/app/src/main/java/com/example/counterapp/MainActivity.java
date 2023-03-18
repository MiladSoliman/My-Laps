package com.example.counterapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.media.VolumeShaper;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView counter;
    private  static int previousOrientation = Configuration.ORIENTATION_UNDEFINED;

    private int counterRotation ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        counter=findViewById(R.id.tv_counter);
        int currentOrientation = getResources().getConfiguration().orientation;
        if(previousOrientation != Configuration.ORIENTATION_UNDEFINED  && previousOrientation != currentOrientation){
            if (savedInstanceState!=null) {
                counterRotation = savedInstanceState.getInt("count");
            }
            counterRotation++;
            counter.setText(String.valueOf(counterRotation));


        }
        previousOrientation = currentOrientation;

    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt("count", counterRotation);
    }

}
