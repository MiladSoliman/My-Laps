package com.example.day4_products

import java.io.Serializable

class MyResponse (var skip:Int , var total:Int , var limit:Int ,var products : ArrayList<Product> ) :Serializable {
}


class Product constructor (var title:String,var description:String,var thumbnail:String , var rating:Double) :
    Serializable {

}