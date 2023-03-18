package com.example.fab;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
    Animation rotOpen ;
    Animation rotClose;
    Animation fromButtom;
    Animation toButtom;
    FloatingActionButton btn_menue , btn_prof , btn_settings , btn_home;

    TextView text ;
    boolean isShow = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rotOpen = AnimationUtils.loadAnimation(this,R.anim.rotate_open_anim);
        rotClose = AnimationUtils.loadAnimation(this,R.anim.rotate_closed_anim);
        fromButtom = AnimationUtils.loadAnimation(this,R.anim.from_bottom_anim);
        toButtom = AnimationUtils.loadAnimation(this,R.anim.to_bottom_anim);

        btn_menue = findViewById(R.id.fab_menu);
        btn_home = findViewById(R.id.fab_home);
        btn_prof = findViewById(R.id.fab_profile);
        btn_settings = findViewById(R.id.bt_fabSett);


        btn_menue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isShow) {
                    btn_menue.startAnimation(rotOpen);
                    btn_home.startAnimation(fromButtom);
                    btn_home.show();
                    btn_prof.startAnimation(fromButtom);
                    btn_prof.show();
                    btn_settings.startAnimation(fromButtom);
                    btn_settings.show();
                    isShow=false;
                }else{
                    btn_menue.startAnimation(rotClose);
                    btn_home.startAnimation(toButtom);
                    btn_home.hide();
                    btn_prof.startAnimation(toButtom);
                    btn_prof.hide();
                    btn_settings.startAnimation(toButtom);
                    btn_settings.hide();
                    isShow=true;
                }

            }
        });









    }
}