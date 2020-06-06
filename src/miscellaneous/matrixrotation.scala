package miscellaneous

class matrixrotation {
  def matrixdropOuter(a1: Array[Array[Int]]) = {
    val r = a1.length -1
    val c = a1(0).length - 1
    
   (1 until r).map {r =>
      (1 until c).map { c =>
        a1(r)(c)
      }
    }

  }
}

object matrixrotation {
  def main(args: Array[String]): Unit = {
    val m = new matrixrotation
    val matrix1 = Array(Array(1,2,3,4), Array(5,6,7,8), Array(9,10,11,12), Array(13,14,15,16))
    //val matrix2 = Array(Array(10,20), Array(30,40), Array(50,60))
    
    println(m.matrixdropOuter(matrix1))  //Vector(Vector(6, 7), Vector(10, 11))
  }
}