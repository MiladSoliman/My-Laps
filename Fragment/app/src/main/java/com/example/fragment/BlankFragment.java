package com.example.fragment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class BlankFragment extends Fragment {

private static final String TAG2 = "Ftag";

    public BlankFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG2,"onCreatFragment");


    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank, container, false);

    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i(TAG2,"onStartFragment");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i(TAG2,"onResumeFragment");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.i(TAG2,"onPauseFragment");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i(TAG2,"onStopFragment");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.i(TAG2,"onDestroyViewFragment");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG2,"onDestoryFragment");
    }


}