package com.example.kotlin_lab1.classes_day3

interface NumberSeries{
    var result:Int
    var start:Int
    fun getnext():Int
    fun reset():Unit
}


class ByTwo : NumberSeries{
    override var result: Int=0
    override var start: Int=0
       set(value) {
           result = value
           field = value
       }
    override fun getnext(): Int {
        result+=2
        return result
    }

    override fun reset() {
       result = start
    }

}

class ByThree:NumberSeries{
    override var result: Int=0
    override var start: Int=0
      set(value) {
          result=value
          field = value
      }
    override fun getnext(): Int {
       result+=3
        return result
    }

    override fun reset() {
       result = start
    }

}


fun main(){
    var byTwo : ByTwo = ByTwo()
    var byThree :NumberSeries = ByThree()
    byTwo.start =2
    byThree.start = 0
    println("//////////BY TWO/////////")
    for (i in 0..6){
        println(byTwo.getnext())
    }
    byTwo.reset()
    println("getnext aftr reset")
    println(byTwo.getnext())
    println("//////////BY THREE/////////")
    for (i in 0..6){
        println(byThree.getnext())
    }
    println("getnext aftr reset")
    byThree.reset()
    println(byThree.getnext())


}