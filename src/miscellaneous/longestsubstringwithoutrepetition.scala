package miscellaneous

import scala.collection.mutable

class longestsubstringwithoutrepetition {
  def func(s: String): Int = {
    
    var map = mutable.HashSet[Char]()
    var j = 0 
    var i = 0
    
    var max = 0 
    
    s.indices.foreach(idx =>
      idx match {
        case idx if (map.isEmpty == true) => map.add(s(idx))
        case idx if ((!map.isEmpty) && map.contains(s(idx)) == false ) => {
          map.add(s(idx))
          j += 1
          max = math.max(max, map.size)
        }
        case idx if ((!map.isEmpty) && map.contains(s(i)) == true ) =>  {
          map.remove(s(i))
          i += 1
        }
      }
   )
   max
          
  }
}

object longestsubstringwithoutrepetition {
  def main(args: Array[String]): Unit = {
    val lst = new longestsubstringwithoutrepetition
    
    val s = "pwwkew"
    println(lst.func(s))
  }
}