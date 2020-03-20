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
    val sq = new Square(4)
    printShape(sq)
    val sq1 = new MutableSquare(5)
    //sq1.width = 10        //square becomes rectangle due to this update
    printShape(sq1)
    print(sq.length)        //extracting subtype info stored in supertype 
  }
  
  def printShape(s: Shape):Unit = {
    println("area = ", s.area)
  }
}