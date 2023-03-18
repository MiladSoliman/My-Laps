package com.example.kotlin_lab1.day6

import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
       runBlocking {
         var jop1 =    launch {
             delay(1000)
                println("Launch one")

        }
       jop1.join()
         launch {
             delay(900)
             println("launch two")
         }


    }

   /* runBlocking {
        var jop1 = launch {

            for (i in 0..10) {
                println("launch-1 $i ")
                delay(100)
            }

        }
        delay(500)
        jop1.cancelAndJoin()
        launch {
            delay(500)
            println("launch two")
        }


    }*/
}