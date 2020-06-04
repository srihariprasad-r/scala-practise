package scala99problems

class problem14 {
  def addDuplicates[A](l:List[A]):List[A] = {
    l.flatMap(x => List(x,x))
  }
  
}

object problem14 {
  def main(args: Array[String]): Unit = {
    val p14 = new problem14
    val list1 = List(1,2,3,4)
    println(p14.addDuplicates(list1)) //List(1, 1, 2, 2, 3, 3, 4, 4)
  }
}