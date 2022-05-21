package polymorphism

class Circle(val r: Double) extends Shape {
  override def area: Double = math.Pi*r*r
  override def perimeter: Double = 2*math.Pi*r*r  
}