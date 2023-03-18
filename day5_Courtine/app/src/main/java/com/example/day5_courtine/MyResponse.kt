package com.example.day5_courtine

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

class MyResponse (var skip:Int , var total:Int , var limit:Int ,var products : List<Product> ) :
    Serializable {
}

@Entity (tableName = "proudct_table")
class Product constructor (var title:String,var description:String,@PrimaryKey var thumbnail:String , var rating:Double) :
    Serializable {

}