package com.example.myapplication;

import retrofit2.Call;
import retrofit2.http.GET;

public interface API_Service {
    @GET("products")
    public Call<MyResponse> getProudcts();

}
