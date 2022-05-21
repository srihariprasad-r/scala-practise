package polymorphism

class MutableRectangle(private var _width:Double, private var _height:Double) extends Shape {
  def width = _width
  def height = _height
  def width_=(w:Double) = _width = w     //setter property
  def height_=(h:Double) = _height = h  
  override def area: Double = width * height
  override def perimeter: Double = 2* width  + height  
}