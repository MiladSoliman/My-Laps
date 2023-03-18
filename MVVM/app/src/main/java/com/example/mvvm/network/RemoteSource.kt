package com.example.mvvm.network

import com.example.mvvm.model.Product

interface RemoteSource {
    suspend fun getAllProducts() : List<Product>

}