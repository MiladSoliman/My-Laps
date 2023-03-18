package com.example.databaseapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    static String Tag = "Tag";
    static String Tag2 = "Tag2";
    Button send;
    Button close;
    EditText username;
    EditText usermobile;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        send = findViewById(R.id.bt_send);
        close = findViewById(R.id.bt_close);
        username =findViewById(R.id.tb_name);
        usermobile = findViewById(R.id.tb_phone);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = username.getText().toString();
                String phone= usermobile.getText().toString();
                if(name.length()==0||phone.length()==0){
                    Toast.makeText(MainActivity.this, "please enter data which needed", Toast.LENGTH_SHORT).show();
                }else{
                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                    intent.putExtra(Tag, name);
                    intent.putExtra(Tag2, phone);
                    startActivity(intent);
                }
            }
        });


        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }




}