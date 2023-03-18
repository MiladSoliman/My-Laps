package com.example.kotlin_lab1.complex

class Complex constructor(var real :Int , var imag:Int){
    constructor():this(0,0)

}
infix operator fun Complex.plus(complex: Complex ):Complex{
    return Complex(this.real+complex.real,this.imag+complex.imag)
}

infix operator fun Complex.minus(complex: Complex):Complex{
    return Complex(this.real-complex.real,this.imag-complex.imag)
}

fun Complex.print(complex: Complex = Complex(0,0)){
    if (complex.imag<0){
        println(" ${complex.real}  ${complex.imag} i ")
    }else{
        println(" ${complex.real}  + ${complex.imag} i ")
    }
}


fun main (){
    var c1 : Complex = Complex(1,2)
    var c2 : Complex = Complex(4,5)

    var c3 :Complex = Complex()
    var c4 :Complex = Complex()
    c3 = c1+c2
    c4 = c1-c2

    Complex().print(c3)
    Complex().print(c4)
    Complex().print()
}