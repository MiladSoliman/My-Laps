package com.example.mvvm.allProducts.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvm.model.Product
import com.example.mvvm.model.RepositoryInterface
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AllProductsViewModel (private val  myrepo: RepositoryInterface) :ViewModel() {
      private var myProducts : MutableLiveData<List<Product>> = MutableLiveData<List<Product>>()
      val _myProducts : LiveData<List<Product>> = myProducts

      init {
          getAllProduct()
      }

     fun getAllProduct() {
        viewModelScope.launch (Dispatchers.IO){
           myProducts.postValue(myrepo.getAllProducts())
        }
    }

     fun addProduct(product: Product){
        viewModelScope.launch(Dispatchers.IO){
            myrepo.insertProduct(product)
        }
    }

}