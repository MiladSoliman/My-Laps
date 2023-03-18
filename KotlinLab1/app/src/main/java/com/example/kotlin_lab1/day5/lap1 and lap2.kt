package com.example.kotlin_lab1.day5

class Person (var name:String , var gender:String , var id:Int){
    fun printInfo(){
        println("the name is $name , the gender is $gender and the id is $id")
    }
}



fun main(){
   var person:Person = Person("Milad","Male",10)
    person.printInfo()
    person.let {
        it.id=15
        it.name="Miladddddd"
    }
    person.printInfo()
    println("////////////////////////////////////////")
    person.run {
        id=20
        name="Milaaaaaaaaaaad"
    }
    person.printInfo()
    println("////////////////////////////////////////")

    person.also {
        it.id=25
        it.name = "MiLLLLLLLLLLLAd"
    }
    person.printInfo()


}