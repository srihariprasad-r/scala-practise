package miscellaneous

class matrixrotation {
  def matrixdropOuter(a1: Array[Array[Int]], a2: Array[Array[Int]]) = {
    val r = a1.length -1
    val c = a1(0).length - 1
    //code for displaying innermost square of a matrix n*n
   (1 until r).map {r =>
      (1 until c).map { c =>
        a1(r)(c)
      }
    }
    
   //addition of two matrices 
   (0 to r).map {r =>
      (0 to c).map { c =>
        a1(r)(c) + a2(r)(c)
      }
    }    

  }
}

object matrixrotation {
  def main(args: Array[String]): Unit = {
    val m = new matrixrotation
    
    //val matrix1 = Array(Array(1,2,3,4), Array(5,6,7,8), Array(9,10,11,12), Array(13,14,15,16))
    
    //code results display inner most square of a matrix. Function uses only one argument, not two
    //println(m.matrixdropOuter(matrix1))  //Vector(Vector(6, 7), Vector(10, 11))    
    
    val matrix1 = Array(Array(1,2), Array(3,4))
    val matrix2 = Array(Array(10,20), Array(30,40))
    
    //code to print new matrix with sum of two matrices. function takes two arguments
    println(m.matrixdropOuter(matrix1, matrix2))  //Vector(Vector(11, 22), Vector(33, 44))

  }
}