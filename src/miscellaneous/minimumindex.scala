package miscellaneous

import scala.collection.mutable

class minimumindex {
  def func(l1: Array[String],l2: Array[String]): Array[String] = {
    val map = mutable.Map[String, Int]()
    
    for ( i <- l1.indices) {
      if (!map.contains(l1(i))) map(l1(i)) = i      
    }
   
    val output = mutable.ListBuffer[(String, Int)](("", Int.MaxValue))
    
    for (i <- l2.indices) {
      if (map.contains(l2(i))) {
        val cmnidex  = i + map(l2(i))
        if ( cmnidex < output.head._2) {
          output.clear()
          output.append((l2(i), cmnidex))
         } else if (cmnidex == output.head._2)  output.append((l2(i), cmnidex)) 
       }
     }
    output.map{case (x, y) => x}.toArray
   }
}


object minimumindex {
  def main(args: Array[String]): Unit = {
    val midx = new minimumindex
    val l1 = Array("Shogun", "Tapioca Express", "Burger King", "KFC")
    val l2 = Array("Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun")
    
    println(midx.func(l1, l2))    //"Shogan"
    
  }
}