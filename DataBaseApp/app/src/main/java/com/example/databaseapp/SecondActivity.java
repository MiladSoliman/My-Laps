package com.example.databaseapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.databaseapp.db.DataBaseAdapter;
import com.example.databaseapp.db.UserDTO;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class SecondActivity extends AppCompatActivity {
    TextView userName;
    TextView userPhone;
    Button close;
    Button sendShare;
    Button readShare;
    Button sendInter;
    Button readInter;
    Button sendData;
    Button readData;
    FileInputStream fis;
    FileOutputStream fos;
    DataInputStream dis;
    DataOutputStream dos;

    private static final String FILE_NAME = "user data";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        userName = findViewById(R.id.tv_username);
        userPhone = findViewById(R.id.tv_userphone);
        close = findViewById(R.id.btn_end);
        sendShare = findViewById(R.id.btn_send_share);
        readShare = findViewById(R.id.btn_read_share);
        sendInter = findViewById(R.id.btn_send_inter);
        readInter = findViewById(R.id.btn_read_inter);
        sendData = findViewById(R.id.btn_send_data);
        readData = findViewById(R.id.btn_read_data);
        Intent myInt = getIntent();
        if(myInt!=null){
            String str = myInt.getStringExtra(MainActivity.Tag);
            userName.setText(str);
            String str2 = myInt.getStringExtra(MainActivity.Tag2);
            userPhone.setText(str2);
        }

        sendShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = userName.getText().toString();
                String phone = userPhone.getText().toString();
                SharedPreferences sharedPreferences = getSharedPreferences("credentals",MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("user_name",name);
                editor.putString("user_phone",phone);
                editor.commit();
                userName.setText("");
                userPhone.setText("");
            }
        });

        readShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getSharedPreferences("credentals",MODE_PRIVATE);
                String name= sharedPreferences.getString("user_name","name not found");
                String phone= sharedPreferences.getString("user_phone","phone not found");
                userName.setText(name);
                userPhone.setText(phone);
            }
        });

        sendInter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    fos = openFileOutput(SecondActivity.FILE_NAME, Context.MODE_PRIVATE);
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }
                dos = new DataOutputStream(fos);
                try {
                    dos.writeUTF(userName.getText().toString());
                    dos.writeUTF(userPhone.getText().toString());
                    dos.close();
                    fos.close();
                }catch (IOException e){
                    throw new RuntimeException(e);
                }
                userName.setText("");
                userPhone.setText("");
            }
        });


        readInter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    fis = openFileInput(SecondActivity.FILE_NAME);
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }
                dis = new DataInputStream(fis);
                try {
                    userName.setText(dis.readUTF());
                    userPhone.setText(dis.readUTF());
                    dis.close();
                    fis.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        sendData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = userName.getText().toString();
                String phone = userPhone.getText().toString();
                UserDTO user = new UserDTO(name,phone);
                DataBaseAdapter dataBaseAdapter = new DataBaseAdapter(SecondActivity.this);
                dataBaseAdapter.addUser(user);
                userName.setText("");
                userPhone.setText("");

            }
        });

        readData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DataBaseAdapter dataBaseAdapter = new DataBaseAdapter(SecondActivity.this);
                UserDTO user = dataBaseAdapter.getUrse();
                userName.setText(user.getUserName());
                userPhone.setText(user.getPhone());
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