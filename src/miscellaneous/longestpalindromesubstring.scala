package miscellaneous

import scala.collection.mutable

class longestpalindromesubstring {
  
  def func(s: String) = {    
    var oldmap = mutable.ListBuffer[Char]()
    var newmap = List[List[Char]]()
    
    var start = s.length()
    var end = 0 
    
    def innerfunc(start: Int, end: Int): Unit  = {
      if (s.length() == 0)  Nil 
      else if (start >= 0 && end <= s.length()) {
        if (s.charAt(start) == s.charAt(end))  {
          if (oldmap.isEmpty) oldmap = mutable.ListBuffer(s(end)) 
          else oldmap += s(end) 
          innerfunc(start - 1, start + 1)
        }
        else {
          newmap = List(oldmap.toList) ::: newmap
          oldmap.clear()       
          innerfunc(start - 1, start + 1)
        }
      }
    }
   innerfunc(start,end)
   println(newmap, oldmap)  
  }
  
}

object longestpalindromesubstring {
  
  def main(args: Array[String]): Unit = {
    val lps = new longestpalindromesubstring
    
    val s = "bab"
    
    println(lps.func(s))
    
  }
}