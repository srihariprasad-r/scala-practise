package miscellaneous

import scala.collection.mutable

class longestsubstringwithoutrepetition {
  def func(s: String): Int = {
    
    var map = mutable.HashSet[Char]()
    var right = 0 
    var left = 0
    
    var max = 0 
    
    s.indices.foreach(idx =>
      idx match {        
        case idx => { 
          if (map.add(s.charAt(right))) {          
          right += 1        
          max = math.max(max, map.size)
        }
          else {           
            map.remove(s.charAt((left)))
            left += 1       
          }
        }
      }
   )
   max 
  }
}

object longestsubstringwithoutrepetition {
  def main(args: Array[String]): Unit = {
    val lst = new longestsubstringwithoutrepetition
    
    val s = "aab"
    println(lst.func(s))
  }
}