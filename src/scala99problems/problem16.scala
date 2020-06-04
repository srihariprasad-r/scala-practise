package scala99problems

class problem16 {
  def dropElements[A](l:List[A],n: Int): List[A] = {
  def dropN[A](curList: List[A], k: Int, ls: List[A]):List[A] = (curList, k) match  {
    case (Nil, _) => ls.reverse
    case (_:: tail, 1) => dropN(tail, n, ls)
    case(h::tail, _) => dropN(tail, k-1, h :: ls)
  }
  dropN(l, n, Nil)
}
  
}

object problem16 {
  def main(args: Array[String]): Unit = {
    val p16 = new problem16
    val list1 = List(1,2,3,4,5)
    println(p16.dropElements(list1, 4))  //List(1, 2, 3, 5)

    
  }
}