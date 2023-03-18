package com.example.kotlin_lab1.classes_day3

class Person {
    var name :String = ""
    var address:Person.Address=Person.Address()

    class Address{
        var streetName:String = ""
        var city:String = ""
        var bulding:Bulding= Bulding.APARTMENT
    }
}

enum class Bulding{
    VILLA,
    APARTMENT
}

fun main(){
    var person:Person = Person()
    person.name="Milad"
    person.address?.streetName = "Hoda El-eslam"
    person.address?.city ="Alexandria"
    person.address?.bulding=Bulding.VILLA

    println("My Name is ${person.name} ,,, My Address is ${person.address?.city},${person.address?.streetName},${person.address?.bulding}")



}