package scala99problems

class problem19 {
  def problem[A](ls: List[A], start: Int): List[A] = {
    def rotateElements[A](curList: List[A], k: Int, rem: List[A]): List[A] = (curList, k) match  {
      case (Nil, _ ) => rem
      case (h , k) if k ==0 => h ::: rem
      case ((l: List[_]), k) if k ==0 =>  l ::: rem
      case(h ::tail, k) => rotateElements(tail, k-1 , rem ::: List(h))
    }
  rotateElements(ls, start, Nil)
  }
}

object problem19 {
  def main(args: Array[String]): Unit = {
    val p18 = new problem19
    val list1 = List(1,2,3,4,5)
    println(p18.problem(list1, 3))  //List(4, 5, 1, 2, 3)

    
  }
}