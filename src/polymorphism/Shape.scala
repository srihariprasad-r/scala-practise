package polymorphism

class Shape {
  def area: Double = 0.00
  def perimeter: Double = 0.00
  
}

object Shape {
  def main(args:Array[String]):Unit =  {
    val rect = new Rectangle(3,4)
    printShape(rect)
    val cir = new Circle(2)
    printShape(cir)
  }
  
  def printShape(s: Shape):Unit = {
    println("area = ", s.area)
  }
}