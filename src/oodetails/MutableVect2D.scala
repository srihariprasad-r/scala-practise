package oodetails

class MutableVect2D(private var _x: Double, private var _y: Double) {
  def x = _x
  
  def y = _y
  
  def x_=(newX: Double) :Unit = _x = newX      //property assignments
  
  def y_=(newY: Double) :Unit = _y = newY  
  
  def plus(mv:MutableVect2D):MutableVect2D = {
    _x += mv.x
    _y += mv.y
    this
  }
  
  def minus(mv:MutableVect2D):MutableVect2D = {
    _x -= mv.x
    _y -= mv.y
    this
  }
  
  def scale(c:Double):MutableVect2D = {
    _x *= c
    _y *= c
    this
  }  
}

object MutableVect2D {        //companion object
  def main(args:Array[String]):Unit = {
    val v1 = new MutableVect2D(1,2)
    val v2 = new MutableVect2D(2,2)
    v1.plus(v2)
    v1.x = 10
    print(v1.x)
  }
}