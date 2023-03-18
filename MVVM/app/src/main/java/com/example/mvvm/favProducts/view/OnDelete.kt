package com.example.mvvm.favProducts.view

import com.example.mvvm.model.Product

interface OnDelete {
    fun deleteProduct(product:Product)
}