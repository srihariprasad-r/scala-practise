package scala99problems

/* Find last element in the list
 * scala> last(List(1, 1, 2, 3, 5, 8))
 * res0: Int = 8
 */

class problem1 {
  def lastElement[A](l:List[A]):A = l match {
    case h :: Nil => h
    case h :: tail => lastElement(tail)
    case _ => throw new NoSuchElementException
  }
}


object problem1 {
  def main(args:Array[String]):Unit = {
  val p1 = new problem1()
  val list1 = List(1, 1, 2, 3, 5, 8)
  println(p1.lastElement(list1))  
}
}

