package scala99problems

/* Find count of elements in the list
 * scala> List(1, 1, 2, 3, 5, 8) 
 * res0: Int = 5 
 */


class problem4 {
    def findElementCount[A](a:Int, l:List[A]):Int = l match {
    case Nil => a       
    case head :: tail => findElementCount(a + 1 , l.tail)    
    case _ => throw new NoSuchElementException
  }
}

object problem4 {
  def main(args: Array[String]):Unit = {
    val p4 = new problem4
    val list1 = List(1, 1, 2, 3, 5, 8) 
    println(p4.findElementCount(0, list1))
  }
}