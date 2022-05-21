package scala99problems

class problem7 {
    //this method is needed as flattem cannot be applied when there are primitive data types such as Int
    def flattenList[A](l:List[Any]):List[Any] = l match {
    case Nil => Nil     
    case (l: List[_]) :: tail => flattenList(l):::flattenList(tail)
    case h::tail => h::flattenList(tail)    
  }
}

object problem7 {
  def main(args: Array[String]):Unit = {
    val p7 = new problem7
    val list1 = List(List(1, 1), 2, List(3, List(5, 8)))
    //println(p7.flattenList(list1))    //List(1, 1, 2, 3, 5, 8)
    } 
    
  }




