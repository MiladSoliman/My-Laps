
package com.example.kotlin_lab1
import java.util.Random;


fun main(){

  //Lab 1

 /* println("Enter your Name")

  var name :String? = readLine()
  if (name.isNullOrBlank()){
   println("Hello NoOne")
  }else {
   println("Hello : $name")
  }*/



    //Lab2

/*val arr1 = arrayOfNulls<Int>(100)
 for (i in 0 until 100){
  var random = (1..100).random()
  arr1.set(i,random)
  //println(arr1[i])
 }
 for (i in 0 until  arr1.size ){
  if (arr1[i] in 0..10){
   println(arr1[i])
  }
 }*/



    //Lab3

 /* println("Enter First Number")
    var n1 = readLine()
    var number1 = n1?.toIntOrNull() // tointorNull
    println("Enter Second Number")
    var n2 =readln()
    var number2 = n2?.toIntOrNull()
    println("Enter the operator")
    var operator = readln()
    val result = 0f

    if (!n1.isNullOrEmpty()&&!n2.isNullOrEmpty()&&!operator.isEmpty()){
      when{
          operator == "+"  -> {
              var sum = number1?.plus(number2!!)
              println("The Sum is " + sum)
          }
          operator == "-" ->{
              var sum = number1?.minus(number2!!)
              println("The Abstraction is " + sum)
          }
          operator=="*"->{
              var sum = number1?.times(number2!!)
              println("The Multiplay is " + sum)
          }
          operator=="/"->{
              if (number2 == 0 ){
                  println("undefined")
              }else{
                  var sum = number1?.div(number2!!)
                  println("The division is " + sum)
              }
          }
      }


    }else{
        println(" please enter right format")
    }*/







    //Lab4

 /*  println("Enter First Name")
    var firstName:String? = readLine()
    println("Enter Second Name")
    var seconName:String? = readLine()
    if (firstName.isNullOrBlank()&&seconName.isNullOrBlank()) {
        println("please enter right names")

    }else {
        println("the full name is " + firstName + " " + seconName)
    }*/





//Lab5

 /*var star = "*"
 var spaceStar = "* "
 for (i in 0 until 8){
     print(star)
     for (j in 8 downTo  i){
         print("  ")
     }
     println(spaceStar)
     star +="*"
     spaceStar+="* "

 }*/





}