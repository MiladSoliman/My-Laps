package com.example.navugation_1;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.navugation_1.FirstFragmentDirections;


public class FirstFragment extends Fragment {
 TextView one;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        one = view.findViewById(R.id.tv_one);
        one.setOnClickListener(v->{
            Navigation.findNavController(v).navigate(R.id.action_firstFragment_to_secondFragmen);
           // FirstFragmentDirections.ActionFirstFragmentToSecondFragmen action = FirstFragmentDirections.actionFirstFragmentToSecondFragmen();
        });
    }
}