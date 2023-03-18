package com.example.versionofmobiles;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.webkit.HttpAuthHandler;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import javax.net.ssl.HttpsURLConnection;

public class MainActivity extends AppCompatActivity {
  static ArrayList<Products> Products= new ArrayList<Products>();
  TextView title;
  TextView price;
  TextView brand;
  TextView decreption;
  RatingBar rating;
  ImageView img;

  Button next;
  Button prev;

  static int countr = -1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        title = findViewById(R.id.tv_title);
        price = findViewById(R.id.tv_price);
        brand = findViewById(R.id.tv_brand);
        decreption = findViewById(R.id.tv_desc);
        rating = findViewById(R.id.ratingBar);
        rating.setEnabled(false);
        img=findViewById(R.id.img_view);
        next = findViewById(R.id.btn_next);
        prev= findViewById(R.id.btn_preveious);
        new GetPhons().execute();

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countr++;
                if(countr<Products.size()) {
                    Products p = Products.get(countr);
                    title.setText(p.getTitle());
                    price.setText(String.valueOf(p.price));
                    brand.setText(p.getBrand());
                    decreption.setText(p.getDecription());
                    rating.setRating((float) p.getRating());
                    String urlImag = p.getThumbnail();
                    new DawinlodaTask().execute(urlImag);
                    //countr++;
                }else{
                    Toast.makeText(MainActivity.this, "Sorry no more version of phones", Toast.LENGTH_SHORT).show();
                }
            }
        });
        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if(countr>0) {
                   countr--;
                    Products p = Products.get(countr);
                    title.setText(p.getTitle());
                    price.setText(String.valueOf(p.price));
                    brand.setText(p.getBrand());
                    decreption.setText(p.getDecription());
                    rating.setRating((float) p.getRating());
                    String urlImag = p.getThumbnail();
                    new DawinlodaTask().execute(urlImag);
               }else {
                    Toast.makeText(MainActivity.this, "Sorry it's no more version of phones", Toast.LENGTH_SHORT).show();
                }
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
        }//finally {
            //conn.disconnect();
       // }

        return  result;
    }

    class GetPhons extends AsyncTask<Void,Void,Void>{

        @Override
        protected Void doInBackground(Void... voids) {
            HttpHandeler sh = new HttpHandeler();
            String url = "https://dummyjson.com/products";
            try {
                String jsonString = sh.getConnection(url);
                if(jsonString!=null){
                    JSONObject jsonObject = new JSONObject(jsonString);
                    JSONArray prouduct = jsonObject.getJSONArray("products");
                    for(int i = 0 ; i<prouduct.length();i++){
                        JSONObject p = prouduct.getJSONObject(i);
                        String title = p.getString("title");
                        String descreption = p.getString("description");
                        double price = p.getInt("price");
                        double rating = p.getDouble("rating");
                        String brand = p.getString("brand");
                        String thumbnail = p.getString("thumbnail");
                        Products product = new Products(title,descreption,price,rating,brand,thumbnail) ;
                        Products.add(product);
                    }
                }

            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
            return null;
        }
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
            //Toast.makeText(MainActivity.this, "DONE", Toast.LENGTH_SHORT).show();
        }
    }
}


