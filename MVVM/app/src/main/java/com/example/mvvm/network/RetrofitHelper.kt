package com.example.mvvm.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper{
    const val BASE_URL = "https://dummyjson.com/"
    val retrofitInstance = Retrofit.Builder().baseUrl( BASE_URL).addConverterFactory(
        GsonConverterFactory.create()).build()
}


object MyApi {
    val retrofirService: ApiService by lazy {
        RetrofitHelper.retrofitInstance.create(ApiService::class.java)
    }
}