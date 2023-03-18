package com.example.kotlin_lab1.day6

import kotlinx.coroutines.*

fun main (){
    runBlocking {
            var jop1 = launch {
              try {
                  for (i in 0..10){
                      println("Launch $i")
                      delay(250)
                  }
              }   catch(th :CancellationException ) {
                  println(th.message)
              }
            }

            var jop2 = async {
                try {
                    repeat(10){
                        println("Async $it")
                        delay(250)
                    }
                } catch(th :CancellationException ) {
                    println(th.message)
                }

            }
        delay(1000)
        jop1.cancel()
        jop2.cancel()
        println("Canceld")
    }

}