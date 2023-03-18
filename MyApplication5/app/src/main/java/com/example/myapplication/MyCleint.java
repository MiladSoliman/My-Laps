package com.example.myapplication;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MyCleint {
    private static MyCleint instance = null;
    private API_Service myApi;
    String BASE_URL = "https://dummyjson.com";

    private MyCleint() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL )
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        myApi = retrofit.create(API_Service.class);

    }

    public static synchronized MyCleint getInstance() {
        if (instance == null) {
            instance = new MyCleint();
        }
        return instance;
    }

    public API_Service getMyApi() {
        return myApi;
    }
}
