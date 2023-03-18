package com.example.kotlin_lab1.day6

import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main (){
val jop = runBlocking {
           launch {
               for (i in 0..10){
                   println("Launch $i")
                   delay(10)
               }
           }
           async {
               repeat(10){
                   println("Async $it")
                   delay(10)
               }
           }
          }





}