package com.example.mvvm.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.mvvm.model.Product

@Dao
interface ProductDao {
    @Query("SELECT * From products")
    suspend fun getFavProducts(): List<Product>
    @Insert(onConflict = OnConflictStrategy.IGNORE)
   suspend fun insertProduct(product: Product)
    @Delete
    suspend fun deleteMovie(product: Product?)

}