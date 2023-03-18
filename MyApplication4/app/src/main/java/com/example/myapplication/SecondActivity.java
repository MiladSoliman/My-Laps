package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    Button close;
    TextView user_name;
    TextView user_mobile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        close = findViewById(R.id.bt_end);
        user_name= findViewById(R.id.tv_username);
        user_mobile = findViewById(R.id.tv_usermobile);
        Intent myInt = getIntent();
        if(myInt!=null){
            String str = myInt.getStringExtra(MainActivity.Tag);
            user_name.setText(str);
            String str2 = myInt.getStringExtra(MainActivity.Tag2);
            user_mobile.setText(str2);
        }

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

}