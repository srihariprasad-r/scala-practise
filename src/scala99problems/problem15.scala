package scala99problems

class problem15 {
  def timesDuplicates[A](l:List[A],n: Int):List[A] = {
    l.flatMap(x => List.fill(n)(x))
  }
  
}

object problem15 {
  def main(args: Array[String]): Unit = {
    val p15 = new problem15
    val list1 = List(1,2,3,4)
    println(p15.timesDuplicates(list1,3)) //List(1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4)
  }
}