package scala99problems


/* Find count of elements in the list
 * scala> List(1,1,2,3,5,6)
 * res0: List(6, 5, 3, 2, 1, 1)
 */


class problem5 {
    def reverseElementCount[A](l:List[A]):List[A] = l match {
      case Nil => l       
      case head :: tail => reverseElementCount(l.tail) ::: List(head)   
      case _ => throw new NoSuchElementException
  }
}

object problem5 {
  def main(args: Array[String]): Unit = {
    val p5 = new problem5
    val list5 = List(1,1,2,3,5,6)
    println(p5.reverseElementCount(list5))    
  }
}