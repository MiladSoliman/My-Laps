package com.example.mvvm.database

import com.example.mvvm.model.Product

interface LocalSource {
    suspend fun insertProduct(product: Product)
    suspend fun deletProduct(product: Product)
    suspend fun getLocalProducts():List<Product>
}