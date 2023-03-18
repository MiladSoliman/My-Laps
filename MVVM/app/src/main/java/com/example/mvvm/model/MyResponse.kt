package com.example.mvvm.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

class MyResponse (var skip:Int , var total:Int , var limit:Int ,var products : List<Product> ) :
    Serializable {
}

@Entity(tableName = "products")
class Product constructor (@ColumnInfo var title:String,@ColumnInfo var description:String,@PrimaryKey var thumbnail:String , @ColumnInfo var rating:Double , @ColumnInfo var brand:String ,@ColumnInfo var price :String) :
    Serializable {

}
