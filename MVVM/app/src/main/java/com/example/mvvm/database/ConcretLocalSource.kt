package com.example.mvvm.database

import android.content.Context
import com.example.mvvm.model.Product
import com.example.mvvm.network.ProductClient

class ConcretLocalSource private constructor(context: Context) : LocalSource {

   private val dao:ProductDao by lazy{
        val db:AppDatabase = AppDatabase.getInstance(context)
        db.getProductDao()
    }

    companion object{
        @Volatile
        private var INSTANCE : ConcretLocalSource?=null

        fun getInstance(context: Context): ConcretLocalSource {
            return INSTANCE?: synchronized(this){
                val temp = ConcretLocalSource(context)
                INSTANCE=temp
                temp
            }
        }
    }


    override suspend fun insertProduct(product: Product) {
       dao.insertProduct(product)
    }

    override suspend fun deletProduct(product: Product) {
       dao.deleteMovie(product)
    }

    override suspend fun getLocalProducts(): List<Product> {
        return dao.getFavProducts()
    }
}