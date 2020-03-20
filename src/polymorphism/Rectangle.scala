package polymorphism

class Rectangle(val w: Double, val h: Double) extends Shape {
  override def area: Double = w*h
  override def perimeter: Double = 2*w +h
  
  
}