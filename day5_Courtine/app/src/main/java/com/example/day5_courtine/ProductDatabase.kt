package com.example.day5_courtine

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Product::class), version = 1)
abstract class ProductDatabase :RoomDatabase() {
    abstract fun getProductDao() : ProductDao
    companion object {
        @Volatile
        private var INSTANCE :ProductDatabase?=null

        fun getInstance (ctx:Context):ProductDatabase{
            return INSTANCE?: synchronized(this){
                val instance  = Room.databaseBuilder(
                    ctx.applicationContext,ProductDatabase::class.java,"Products_DataBase"
                ).build()
                INSTANCE = instance
                instance
            }
        }

    }


}