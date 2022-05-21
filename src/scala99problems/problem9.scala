package scala99problems

// P09 (**) Pack consecutive duplicates of list elements into sublists.
//     If a list contains repeated elements they should be placed in separate
//     sublists.

//pack(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
//List(List('a, 'a, 'a, 'a), List('b), List('c, 'c), List('a, 'a), List('d), List('e, 'e, 'e, 'e))

class problem9 {
  def packDuplicates[A](l:List[A]):List[List[A]] = {
    if (l.isEmpty) List(List())
    else {
      val (hit, others) = l span ( _ == l.head)
      if (others == Nil) List(hit)
      else hit :: packDuplicates(others)
    }
    
  }
  
}

object problem9 {
  def main(args: Array[String]): Unit = {
    val p9 = new problem9
    val list1 = List(1,2,2,2,3, 3)
    println(p9.packDuplicates(list1))    //List(List(1), List(2, 2, 2), List(3, 3))
  }
}