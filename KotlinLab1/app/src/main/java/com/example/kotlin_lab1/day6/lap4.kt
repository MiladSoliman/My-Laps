package com.example.kotlin_lab1.day6

import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

suspend fun sum (arr:Array<Int>):Int{
    var sum :Int=0
    for(i in 0 until arr.size){
        sum=sum+arr[i]
        delay(100)
    }

    return sum
}

fun main() = runBlocking{
    var a = async {
        sum(arrayOf(1,2,3,4,5))
    }
    println(a.await())

}