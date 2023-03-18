package com.example.lif;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "activity LifeCycle";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG, "onACreate: ");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onAStart: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onAResume: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onAPause: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onAStop: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onADestroy: ");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "onARestart: ");
    }
}