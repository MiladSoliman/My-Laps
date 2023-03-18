package com.example.lif;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class BlankFragment extends Fragment {

    private static final String TAG = "Fragment LifeCycle";
    public BlankFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank, container, false);

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onFCreateView: ");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i(TAG, "onFStart: ");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i(TAG, "onFResume: ");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.i(TAG, "onFPause: ");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i(TAG, "onFStop: ");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.i(TAG, "onFDestroyView: ");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onFDestroy: ");
    }
}