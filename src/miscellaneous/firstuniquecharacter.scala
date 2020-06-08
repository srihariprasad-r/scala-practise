package miscellaneous

import scala.collection.mutable

class firstuniquecharacter {
  def func(s1: String): Int = {
    val hmap = mutable.HashMap[Char, Int]()
    
    s1.zipWithIndex.foreach{
        idx => if (hmap.contains(idx._1)) hmap(idx._1) += idx._2
              else hmap(idx._1) = idx._2
             }
          
    hmap.minBy(_._2)._2
  }
}


object firstuniquecharacter {
  def main(args: Array[String]) : Unit = {
    val s = "leetcode"
    
    val fs = new firstuniquecharacter
    println(fs.func(s))
  }
}