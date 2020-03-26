package scala99problems

/* Find last but one element in the list
 * scala> List(1, 1, 2, 3, 5, 8)
 * res0: Int = 5
 */

class problem2 {
  def lastElement[A](l:List[A]):A = l match {
    case h :: List(t) => h      //stop recursion when there is only one list element
    case h :: tail => lastElement(tail)
    case _ => throw new NoSuchElementException
  }
}


object problem2 {
  def main(args:Array[String]):Unit = {
  val p1 = new problem2()
  val list1 = List(1, 1, 2, 3, 5, 8)
  println(p1.lastElement(list1))  
}
}

