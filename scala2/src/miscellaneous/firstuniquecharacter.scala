package miscellaneous

import scala.collection.mutable

class firstuniquecharacter {
  def func(s1: String) = {
    val hmap = mutable.HashMap[Char, Int]()
    
    val cmap: Map[Char,Int] = s1.groupBy(x=> x).mapValues(_.length())
    
    s1.zipWithIndex.foreach{
        idx => if (hmap.contains(idx._1) && (cmap(idx._1) <= 1)) { 
          hmap(idx._1) += idx._2
        }
              else if (hmap.contains(idx._1) == false && (cmap(idx._1) <= 1)) {
                hmap(idx._1) = idx._2
              }
             }
          
    if ((s1.length > 0) && (!hmap.isEmpty)) {
      hmap.minBy(_._2)._2
      } else -1 
    
  }
}


object firstuniquecharacter {
  def main(args: Array[String]) : Unit = {
    val s = "cc"
    
    val fs = new firstuniquecharacter
    println(fs.func(s))
  }
}