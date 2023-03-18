package com.example.recylerviewproducts

import java.io.Serializable

data class Product(var name :String , var img :Int) : Serializable

object RecycleRepo {
    fun getPriducts() = listOf<Product>(
        Product("Apple" , R.drawable.one),
        Product("Nokia" , R.drawable.two),
        Product("Oppo" , R.drawable.three),
        Product("Iphone6" , R.drawable.four),
        Product("Apple 2" , R.drawable.five),
        Product("Nokia 6" , R.drawable.six),
        Product("oppo 2" , R.drawable.seven),
    )

}