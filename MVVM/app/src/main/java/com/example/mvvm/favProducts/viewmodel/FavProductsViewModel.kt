package com.example.mvvm.favProducts.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvm.model.Product
import com.example.mvvm.model.RepositoryInterface
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FavProductsViewModel (private var myrepo:RepositoryInterface) : ViewModel() {
    private var myFavProducts : MutableLiveData<List<Product>> = MutableLiveData<List<Product>>()
    val _myFavProducts : LiveData<List<Product>> = myFavProducts

    init {
        getFavProducts()
    }

    fun getFavProducts() {
       viewModelScope.launch(Dispatchers.IO){
          myFavProducts.postValue(myrepo.getLocalProducts())
       }
    }

    fun removeProduct(product: Product){
        viewModelScope.launch(Dispatchers.IO){
            myrepo.deletProduct(product)
            getFavProducts()
        }
    }
}