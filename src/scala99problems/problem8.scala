package scala99problems

//     Eliminate continous duplicates:
//     scala> compress(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
//     res0: List[Symbol] = List('a, 'b, 'c, 'a, 'd, 'e)

class problem8 {
  def removeDuplicates (l: List[Int]): List[Int] = l match {
    case Nil => l
    case h :: tail => h :: removeDuplicates(tail.dropWhile(_ == h))
    case _ => throw new NoSuchElementException
  
  }
  
}


object problem8 {
  def main(args: Array[String]): Unit = {
    val p8 = new problem8
    val list1 = List(1,2,2,2,3, 3)
    println(p8.removeDuplicates(list1))
  }
}