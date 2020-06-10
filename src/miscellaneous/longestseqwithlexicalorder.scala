package miscellaneous

import scala.collection.mutable

class longestseqwithlexicalorder {
  def func(s: String) = {
    var oldmap =  mutable.ArrayBuffer[Int]()
    var newmap = List[List[Int]]()
        
    for (i <- s) {
      if ((!oldmap.isEmpty) && (oldmap.head.toByte > i.toByte)) {        
        newmap = List(oldmap.toList) ::: newmap
        oldmap.clear()
        oldmap = mutable.ArrayBuffer(i.toByte)
      }
      else if (oldmap.isEmpty) {
        oldmap = mutable.ArrayBuffer(i.toByte)
      }
      else {
        oldmap.prepend(i.toByte)
      }
    }
    newmap.maxBy(_.length).map(x => x.toChar.toString).mkString.reverse
  }
}

object longestseqwithlexicalorder {
  def main(args: Array[String]): Unit = {
    val s = "abcdefaazb"
    
    val ls = new longestseqwithlexicalorder
    println(ls.func(s))    
  }
}