package com.example.kotlin_lab1.day5

val add ={n1:Int ,n2:Int -> n1+n2}
val sub = fun (n1:Int , n2:Int) = n1-n2
val mul = {n1:Int ,n2:Int -> n1*n2}
val div = {n1:Int ,n2:Int ->
           if (n2==0){0}
           else {n1/n2}
           }


fun calculate(n1: Int,n2: Int,equation:(Int,Int)->Int):Int{
    return equation(n1,n2)
}




fun main(){
   var result1 :Int = calculate(9,3, add)
    println("the sum is $result1")
    var result2 :Int = calculate(9,3, sub)
    println("the sub $result2")
    var result3 :Int = calculate(9,3, mul)
    println("the multiplay is $result3")
    var result4 :Int = calculate(9,3, div)
    println("the divison is $result4")

}