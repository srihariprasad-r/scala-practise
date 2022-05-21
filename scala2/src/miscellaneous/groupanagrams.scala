package miscellaneous

import scala.collection.mutable

class groupanagrams {
  def func(s: Array[String]) = {
   
    val map = mutable.Map[String, mutable.ListBuffer[String]]()
    
    for (i <- s) {
      if (map.contains(i.sorted)) {
        map(i.sorted) += i 
      } else {
        map(i.sorted) = mutable.ListBuffer(i)
      }
    }
    
    map.mapValues(_.toList).toList.map(x => x._2)
  }
}

object groupanagrams {
  def main(args: Array[String]): Unit = {
    val s = Array("ate", "tae", "eat","bat","nat", "tan")
    
    val gap = new groupanagrams
    
    println(gap.func(s))
  }
}