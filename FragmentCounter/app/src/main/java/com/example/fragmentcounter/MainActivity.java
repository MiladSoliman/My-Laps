package com.example.fragmentcounter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements Commuicator{
    FirstFragment myFirstFragment;
    SecondFragment mySecondFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager mgr = getSupportFragmentManager();
        FragmentTransaction trans = mgr.beginTransaction();
        if(mgr.findFragmentByTag("myFirstFragment")!=null){
            myFirstFragment = (FirstFragment) mgr.findFragmentByTag("myFirstFragment");
            trans.replace(R.id.fragmentContainerView,myFirstFragment);
        }else{
            myFirstFragment = new FirstFragment();
            trans.add(R.id.fragmentContainerView,myFirstFragment,"myFirstFragment");
        }
        if (mgr.findFragmentByTag("mySecondFragment")!=null){
            mySecondFragment = (SecondFragment)mgr.findFragmentByTag("mySecondFragment");
            trans.replace(R.id.fragmentContainerView2,mySecondFragment);
        }else{
            mySecondFragment = new SecondFragment();
            trans.add(R.id.fragmentContainerView2,mySecondFragment,"mySecondFragment");
        }
        trans.commit();

    }

    @Override
    public void sendData(String data) {
        FragmentManager mgr = getSupportFragmentManager();
        FirstFragment firstFragment = (FirstFragment) mgr.findFragmentById(R.id.fragmentContainerView);
        firstFragment.changeData(data);
    }

}