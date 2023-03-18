package com.example.mvc_project.network;

import com.example.mvc_project.model.MyResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Product_Service {
    @GET("products")
    public Call<MyResponse> getResponse();

}
