package com.example.mvvm.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.mvvm.model.Product

@Database(entities = arrayOf(Product::class), version = 3)
abstract class AppDatabase :RoomDatabase() {
    abstract fun getProductDao() : ProductDao
    companion object {
        @Volatile
        private var INSTANCE :AppDatabase?=null

        fun getInstance (ctx: Context):AppDatabase{
            return INSTANCE?: synchronized(this){
                val instance  = Room.databaseBuilder(
                    ctx.applicationContext,AppDatabase::class.java,"Products_DataBase3"
                ).build()
                INSTANCE = instance
                instance
            }
        }

    }
}