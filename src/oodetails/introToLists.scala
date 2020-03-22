package oodetails

object introToLists {
  def main(args:Array[String]):Unit = {
    val list0 = List() //creates an empty List
    val list1 = List(2)
    
    //auto fill elements with default values based on size
    val list2 = List.fill(6)(0)
    
    //fill values on given based on function literal
    val list3 = List.tabulate(5)(x=> x*2)
    
    //similar to list1 union list2
    val list4 = list2 ++ list3
    
    //append elements before & after 
    val list5 = 3 +: list2  
    val list6 = list2 :+ 6
    
    //foldleft
    val list7 = (0 /: list3)((acc, elem) => (acc+elem))
    val countList7 = (0 /: list3)((acc, elem) => (acc+1))
    val valAndCountList7 = (Tuple2(0,0) /: list3)((acc, elem) => (acc._1+1, elem+acc._2))
    
    //foldright
    val list8 = (list3 :\ 410)((acc,elem) => (acc+elem))
    
    val stringList = List('h','e','l','l','o').addString(new StringBuilder)
    
    println(valAndCountList7)    //prints (5,20)
    //println(countList7)    //prints 5      
    //println(stringList)    //prints "hello"    
    //println(list8)      //accumulator starts from 410 and moves right to left
    //println(list7)    //accumulator starts from 0 and adds element one by one
    //println(list6)      //List(0, 0, 0, 0, 0, 0, 6)
    //println(list5)    //same as :: List(3, 0, 0, 0, 0, 0, 0)
    //println(list4)    //same as ::: List(0, 0, 0, 0, 0, 0, 0, 2, 4, 6, 8)
    //println(list3.init) //List(0, 2, 4, 6)
    //println(list3.head) // 0
    //println(list3.tail) //List(2, 4, 6, 8)
  }
}