package com.example.retrofit;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface API_Service {
    @GET("products")
     Call <ArrayList<MyResponse>> getAllProudcts();
}
