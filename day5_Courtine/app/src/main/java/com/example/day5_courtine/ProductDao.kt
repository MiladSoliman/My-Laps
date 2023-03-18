package com.example.day5_courtine

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query


@Dao
interface ProductDao {
   @Query ("Select * From proudct_table")
   suspend fun getAll():List<Product>
   @Insert(onConflict = OnConflictStrategy.IGNORE)
   suspend fun addProduct(product: Product):Long



}