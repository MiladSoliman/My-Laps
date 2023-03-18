package com.example.day4_products

import java.io.Serializable

data class MyProudcts(var name :String , var img :Int , var rate :Float) : Serializable

object RecycleRepo {
    fun getPriducts() = listOf<MyProudcts>(
        MyProudcts("Apple" , R.drawable.one , 4.5f),
        MyProudcts("Nokia" , R.drawable.two,4.2f),
        MyProudcts("Oppo" , R.drawable.three,4.0f),
        MyProudcts("Iphone6" , R.drawable.four,3.5f),
        MyProudcts("Apple 2" , R.drawable.five,4.0f),
        MyProudcts("Nokia 6" , R.drawable.six,3.7f),
        MyProudcts("oppo 2" , R.drawable.seven,4.0f),
    )

}