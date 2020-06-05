package scala99problems

class problem18 {
  def problem[A](ls: List[A], start: Int, end: Int): List[A] = {
    def sliceElements[A](curList: List[A], k: Int, m: Int,  rem: List[A]): List[A] = (curList, k, m) match  {
      case (Nil, _, _ ) => rem 
      case (_, _ , m) if m <=0 => Nil      
      case (h:: tail, k, m) if k <=0 => h :: sliceElements(tail, 0, m-1, rem)
      case(_ ::tail, k , m ) => sliceElements(tail, k-1 , m-1, rem)
    }
  sliceElements(ls, start, end, Nil)
  }
}

object problem18 {
  def main(args: Array[String]): Unit = {
    val p18 = new problem18
    val list1 = List(1,2,3,4,5)
    println(p18.problem(list1, 2, 5))  //List(3, 4, 5)

    
  }
}