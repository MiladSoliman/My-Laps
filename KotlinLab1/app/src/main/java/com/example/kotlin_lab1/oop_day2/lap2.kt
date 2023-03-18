package com.example.kotlin_lab1.oop_day2

abstract open class Shape constructor(private var dim:Double){
    fun setDim(value: Double){
        if (value<0){
            dim = 0.0
        }else{
            dim = value
        }
    }
    fun getDim () :Double{
        return this.dim
    }
    constructor():this(0.0)
    abstract fun calcArea():Double
}


class Rectangle : Shape {
    var height : Double =0.0
        set(value) {
            if (value<0){
                field=0.0
            }else{
                field=value
            }
        }
    get() {
        return field
    }

    constructor(height:Double , dim: Double) : super(dim){
        if(height>=0) {
            this.height = height
        }
    }
    constructor():super()

    override fun calcArea(): Double {
        return this.height*getDim()
    }
}

class Circle constructor(dim:Double) :Shape(dim) {
    constructor():this(dim = 0.0)

    override fun calcArea(): Double {
       return 3.14*getDim()*getDim()
    }

}

class Triangle : Shape {
    var height : Double =0.0
        set(value) {
            if (value<0){
                field=0.0
            }else{
                field=value
            }
        }
        get() {
            return field
        }

    constructor(height:Double , dim: Double) : super(dim){
        this.height=height
    }
    constructor():super()

    override fun calcArea(): Double {
        return 0.5*height*getDim()
    }

}




class Picture {

    fun sumArea(s1:Shape,s2:Shape,s3:Shape ):Double{
        return s1.calcArea()+s2.calcArea()+s3.calcArea()
    }

}


fun main(){
   var shape1:Shape = Rectangle(3.0,6.0)
   var shape2:Shape = Triangle(3.0,6.0)
    var shape3:Shape = Circle(5.0)

    var pic1:Picture = Picture()

   var sum:Double = pic1.sumArea(shape1,shape2,shape3)

    println("The Total Area is "+ sum)
}