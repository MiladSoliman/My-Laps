package com.example.day4_products

import retrofit2.Call
import retrofit2.http.GET

interface Api {
    @GET("products")
    fun getProducts():Call<MyResponse>
}