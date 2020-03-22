package oodetails

object introToLists {
  def main(args:Array[String]):Unit = {
    val list0 = List() //creates an empty List
    val list1 = List(2)
    val list2 = List.fill(6)(0)
    val list3 = List.tabulate(5)(x=> x*2)
    println(list3.init) //List(0, 2, 4, 6)
    println(list3.head) // 0
    println(list3.tail) //List(2, 4, 6, 8)
  }
}