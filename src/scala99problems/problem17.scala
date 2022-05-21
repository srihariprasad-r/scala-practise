package scala99problems

class problem17 {
  def problem[A](ls: List[A], n: Int):(List[A], List[A]) = {
    def splitElements[A](curList: List[A], k: Int, rem: List[A]):(List[A], List[A]) = (curList, k) match  {
      case (Nil, _) => (rem,Nil) 
      case (_:: tail, 0) => (curList, rem)
      case(h::tail, _) => splitElements(tail, k-1, rem:::List(h))
    }
  splitElements(ls, n, Nil)
  }
}

object problem17 {
  def main(args: Array[String]): Unit = {
    val p17 = new problem17
    val list1 = List(1,2,3,4,5)
    println(p17.problem(list1, 4))  //(List(5),List(1, 2, 3, 4))

    
  }
}