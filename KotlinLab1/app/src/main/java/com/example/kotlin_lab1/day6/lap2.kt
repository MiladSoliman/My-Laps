package com.example.kotlin_lab1.day6

import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

suspend fun factorial(n:Int) :Int {
    var result:Int = 1
    repeat(n){
        result *=(it+1)
        delay(100)
    }
    return result
}


fun main () = runBlocking{
    val asy =async {
        factorial(5)
    }
    println(asy.await())

}