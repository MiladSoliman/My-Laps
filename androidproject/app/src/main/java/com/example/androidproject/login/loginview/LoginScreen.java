package com.example.androidproject.login.loginview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.androidproject.R;
import com.example.androidproject.signup.signupview.SignUp;

public class LoginScreen extends AppCompatActivity {

   TextView signup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);

      signup = findViewById(R.id.tv_regester);

      signup.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Intent intent = new Intent(getApplicationContext(), SignUp.class);
              startActivity(intent);
          }
      });

    }
}