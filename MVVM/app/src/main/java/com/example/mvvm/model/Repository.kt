package com.example.mvvm.model

import com.example.mvvm.database.LocalSource
import com.example.mvvm.network.RemoteSource

class Repository private constructor (var remoteSource: RemoteSource , var localSource: LocalSource): RepositoryInterface {

    companion object{
     private var instance:Repository?=null
        fun getInstance(remoteSource: RemoteSource , localSource: LocalSource):Repository{
            return instance?: synchronized(this){
                val temp = Repository(remoteSource,localSource)
                instance=temp
                temp
            }
        }
    }

    override suspend fun insertProduct(product: Product) {
        localSource.insertProduct(product)
    }

    override suspend fun deletProduct(product: Product) {
        localSource.deletProduct(product)
    }

    override suspend fun getLocalProducts(): List<Product> {
        return localSource.getLocalProducts()
    }

    override suspend fun getAllProducts(): List<Product> {
      return remoteSource.getAllProducts()
    }
}