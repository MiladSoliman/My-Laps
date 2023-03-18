package com.example.mvc_project.network;

import com.example.mvc_project.model.MyResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Product_Client {
    public static final String BaseUrl = "https://dummyjson.com/";
    private static Product_Client client = null ;

    private Product_Client(){};

    public static Product_Client getInstance(){
        if(client==null){
            client = new Product_Client();
        }
        return client;
    }

    public void enqueueCall(NetworkDelegate networkDelegate){
        Gson gson = new GsonBuilder().setLenient().create();
        Retrofit retrofit = new Retrofit.Builder().baseUrl(BaseUrl).addConverterFactory(GsonConverterFactory.create(gson)).build();
        Product_Service product_service = retrofit.create(Product_Service.class);
        Call <MyResponse> call = product_service.getResponse();
        call.enqueue(new Callback<MyResponse>() {
            @Override
            public void onResponse(Call<MyResponse> call, Response<MyResponse> response) {

                networkDelegate.onSuccessResponse(response.body().getProducts());
            }

            @Override
            public void onFailure(Call<MyResponse> call, Throwable t) {
                networkDelegate.onFailureResponse(t.toString());
            }
        });



    }

}
