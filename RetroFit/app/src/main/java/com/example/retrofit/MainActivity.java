package com.example.retrofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;

    LinearLayoutManager layoutManager;
    MyAdabter myAdabter;

    ArrayList<MyResponse> res = new ArrayList<>();

    private static final String BASE_URL = "https://dummyjson.com/";
    private static final String TAG = "API_Client";
   private API_Service apiService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.rv_data);
        Gson gson = new GsonBuilder().create();
        Retrofit retrofit =new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        apiService = retrofit.create(API_Service.class);
        Call<ArrayList<MyResponse>> myResponse = apiService.getAllProudcts();

        Callback <ArrayList<MyResponse>> proudcts =new Callback<ArrayList<MyResponse>>() {
            @Override
            public void onResponse(Call<ArrayList<MyResponse>> call, Response<ArrayList<MyResponse>> response) {
                if(response.isSuccessful()&&response.body()!=null){



                 //  res.add(response.body());
                    layoutManager = new LinearLayoutManager(MainActivity.this);
                    layoutManager.setOrientation(RecyclerView.HORIZONTAL);
                    recyclerView.setLayoutManager(layoutManager);

                    myAdabter = new MyAdabter(MainActivity.this,response.body());
                    recyclerView.setAdapter(myAdabter);

                    Log.i(TAG,"Welcome");
                }
            }

            @Override
            public void onFailure(Call<ArrayList<MyResponse>>call, Throwable t) {
                  t.printStackTrace();
            }
        };
        myResponse.enqueue(proudcts);

      /* layoutManager = new LinearLayoutManager(MainActivity.this);
        layoutManager.setOrientation(RecyclerView.HORIZONTAL);
        recyclerView.setLayoutManager(layoutManager);

        myAdabter = new MyAdabter(MainActivity.this,res);
        recyclerView.setAdapter(myAdabter);*/




    }
}