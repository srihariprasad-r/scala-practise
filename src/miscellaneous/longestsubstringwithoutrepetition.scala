package miscellaneous

import scala.collection.mutable

class longestsubstringwithoutrepetition {
  def func(s: String): Int = {
    
    var map = mutable.ArrayBuffer[Char]()
    
    s.indices.foreach(idx =>
      idx match {
        case idx if (map.isEmpty) => map = mutable.ArrayBuffer(s(idx))
        case idx if ((!map.isEmpty) && map.contains(s(idx)) == false ) => map += s(idx)  
        case idx if ((!map.isEmpty) && map.contains(s(idx)) == true ) => {
          map -= s(idx)
          map += s(idx)
        }
      }
   )
   
   map.length
          
  }
}

object longestsubstringwithoutrepetition {
  def main(args: Array[String]): Unit = {
    val lst = new longestsubstringwithoutrepetition
    
    val s = "abcabcbb"
    println(lst.func(s))
  }
}