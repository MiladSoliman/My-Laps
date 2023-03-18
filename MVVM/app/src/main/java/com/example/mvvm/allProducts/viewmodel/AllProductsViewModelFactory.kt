package com.example.mvvm.allProducts.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mvvm.model.RepositoryInterface

class AllProductsViewModelFactory (private val myrepo:RepositoryInterface) : ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if(modelClass.isAssignableFrom(AllProductsViewModel::class.java)){
            AllProductsViewModel(myrepo) as T
        }else{
            throw java.lang.IllegalArgumentException(" ViewModel Class not Found")
        }
    }
}