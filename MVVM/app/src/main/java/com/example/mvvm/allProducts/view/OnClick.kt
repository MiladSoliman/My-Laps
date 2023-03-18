package com.example.mvvm.allProducts.view

import com.example.mvvm.model.Product

interface OnClick {
  fun addToFavurote(product: Product)
}