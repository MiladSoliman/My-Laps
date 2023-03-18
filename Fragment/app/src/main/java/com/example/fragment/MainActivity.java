package com.example.fragment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "tag";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG,"onCreatActivity");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG,"onStartActivity");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG,"onPauseactivity");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG,"onStopActivity");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG,"onDestroyActivity");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG,"onRestartActivity");
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}