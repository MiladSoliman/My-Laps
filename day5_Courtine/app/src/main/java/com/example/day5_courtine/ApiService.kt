package com.example.day5_courtine

import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiService {
    @GET("products")
    suspend fun getProducts(): Response<MyResponse>
}


object RetrofitHelper{
    const val BASE_URL = "https://dummyjson.com/"
    val retrofitInstance = Retrofit.Builder().baseUrl( BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()
}


object MyApi {
    val retrofirService: ApiService by lazy {
        RetrofitHelper.retrofitInstance.create(ApiService::class.java)
    }
}