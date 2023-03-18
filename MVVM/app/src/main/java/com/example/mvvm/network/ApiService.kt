package com.example.mvvm.network

import com.example.mvvm.model.MyResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("products")
    suspend fun getProducts(): Response<MyResponse>
}