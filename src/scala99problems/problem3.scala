package scala99problems

/* Find kth element in the list
 * scala> List(1, 1, 2, 3, 5, 8) 
 * res0: Int = 1 /* given index 2*/
 */

class problem3 {
  def findKthElement[A](k: Int, l:List[A]):A = k match {
    case 0 => l.head      //stop when k = 0, get the head element at that index 
    case k if k> 0 && k < l.length => findKthElement(k-1, l.tail)
    case k if k > l.length => throw new IllegalArgumentException 
    case _ => throw new NoSuchElementException
  }
}


object problem3 {
  def main(args:Array[String]):Unit = {
  val p1 = new problem3()
  val list1 = List(1, 1, 2, 3, 5, 8)
  println(p1.findKthElement(3, list1))  //element at index is searched
}
}
