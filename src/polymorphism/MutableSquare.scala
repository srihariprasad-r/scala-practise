package polymorphism

class MutableSquare(_length: Double) extends MutableRectangle(_length, _length) {
  //def length = _width      //_width is not seen as it is private in parent class, but is visible when protected
}