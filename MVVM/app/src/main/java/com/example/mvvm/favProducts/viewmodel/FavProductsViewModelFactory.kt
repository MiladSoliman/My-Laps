package com.example.mvvm.favProducts.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mvvm.model.RepositoryInterface

class FavProductsViewModelFactory (private val myRepo: RepositoryInterface) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if(modelClass.isAssignableFrom(FavProductsViewModel::class.java)){
            FavProductsViewModel(myRepo) as T
        }else{
            throw java.lang.IllegalArgumentException(" ViewModel Class not Found")
        }
    }
}