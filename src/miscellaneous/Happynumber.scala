package miscellaneous

import scala.collection.mutable

class HappyNumber {
  def func(a: Int): Boolean = {
    var output: Int = a
    val set = mutable.Set.empty[Int]    
    while ((output != 1) && ((set contains output) == false)) {
      set.add(output)
      output = output.toString.map(x => Math.pow(x.toString.toInt,2)).sum.toInt
      //println(output)
    }    
    val ret = if (output == 1) true else false    
    ret        
  }  
}

object HappyNumber {
    def main(args: Array[String]): Unit = {
      val hn = new HappyNumber
      val arr1 = 19
      println(hn.func(arr1))
        
    }
}