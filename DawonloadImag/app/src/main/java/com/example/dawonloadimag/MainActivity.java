package com.example.dawonloadimag;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class MainActivity extends AppCompatActivity {
    EditText urlText;
    ImageView img;
    Button btn_dawnload;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        urlText = findViewById(R.id.url_text);
        img = findViewById(R.id.iv_image);
        btn_dawnload = findViewById(R.id.bt_dawnload);

        btn_dawnload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = urlText.getText().toString();
                new DawinlodaTask().execute(url);

            }
        });
    }

   Bitmap dawnload (String url) throws IOException {
        Bitmap result =null;
        URL urlObj;
        HttpsURLConnection conn;
        InputStream inputStream = null;
       try {
           urlObj = new URL(url);
           conn =  (HttpsURLConnection)urlObj.openConnection();
           conn.connect();
           if(conn.getResponseCode()== HttpURLConnection.HTTP_OK){
               inputStream = conn.getInputStream();
           }
           result = BitmapFactory.decodeStream(inputStream);
       } catch (IOException e) {
           e.printStackTrace();
       }

       return  result;
   }

    class DawinlodaTask extends AsyncTask<String,Void, Bitmap>{

        @Override
        protected Bitmap doInBackground(String... url) {
            Bitmap result = null ;
            try {
                result = dawnload(url[0]);
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return result;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            img.setImageBitmap(bitmap);
            Toast.makeText(MainActivity.this, "DONE", Toast.LENGTH_SHORT).show();
        }
    }
}