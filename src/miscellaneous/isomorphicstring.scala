package miscellaneous

import scala.collection.mutable
    
class isomorphicstring {
  def func(s1: String, s2: String): Boolean = {
    val map1 = mutable.HashMap[Char, Char]()
    val map2 = mutable.HashMap[Char, Char]()
    
    s1.indices.foreach(index => 
      index match {
        case index if ((map1.contains(s1(index))) && (map1(s1(index))!= s2(index))) => return false
        case index if ((map2.contains(s2(index))) && (map2(s2(index))!= s1(index))) => return false            
        case index => {
              map1(s1(index)) = s2(index)
              map2(s2(index)) = s1(index)
                }
      }
    )
    true
  }  
}

object isomorphicstring {
  def main(args: Array[String]): Unit = {
    val str1 = "egg"
    val str2 = "add"
    val is = new isomorphicstring
    println(is.func(str1, str2))  //false
  }
}