package com.example.mvvm.network

import android.content.Context
import android.util.Log
import androidx.room.Room
import com.example.mvvm.model.Product

class ProductClient : RemoteSource {
    lateinit var myList : List<Product>


    companion object {
        @Volatile
        private var INSTANCE :ProductClient?=null

        fun getInstance():ProductClient{
            return INSTANCE?: synchronized(this){
                val temp = ProductClient()
                INSTANCE=temp
                temp
            }
        }

    }

    override suspend fun getAllProducts(): List<Product> {
        val response = MyApi.retrofirService.getProducts()
        if(response.isSuccessful) {
            myList = response.body()?.products ?: listOf<Product>()
            Log.i("Waslt", myList[0].title)
        }else{
            Log.i("errorrrrr"," dh error"+response.errorBody())
        }
        return myList
    }

}