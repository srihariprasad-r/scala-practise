package oodetails

class introFunctions {
  def square(x:Int):Int = x*x
  
  val f = (x: Int, y: Int) => x+y
  
  val g = square(_)
}

object introFunctions {
  def main(args: Array[String]):Unit = {
    val func = new introFunctions()
    println(func.square(4))
    println(func.f(3,5))
    println(func.g(3))
    
  }
}

