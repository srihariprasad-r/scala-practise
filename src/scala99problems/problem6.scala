package scala99problems


/* Find if list is palindrome in the list
 * scala> List(1,1,2,3,5,6)
 * res0: false
 */


class problem6 {
  def palindromeCheck(a: Boolean, l:List[Int]):Boolean = l match {
    case Nil => a
    case List(h) => a
    case h:: t => palindromeCheck(l.head == l.last, l.tail.init)
  }
}


object problem6 {
  def main(args:Array[String]):Unit = {
    val p6 = new problem6
    val list1 = List(1,2,3,5,6)
    //println(p6.palindromeCheck(true, list1))    
    
    /**
    println(list1.tail)    //List(1, 2, 3, 5, 6)
    println(list1.last) 	// 6 
    println(list1.head)    // 1
    println(list1.init)     //List(1, 1, 2, 3, 5)
    println(list1.tail.init)  //List(1, 2, 3, 5)
    println(list1.reverse.init)  //List(6, 5, 3, 2, 1)
    * */    
    //println(list1.tail.head)
    //println(list1.span{ _ == list1.head})

  }
}  
