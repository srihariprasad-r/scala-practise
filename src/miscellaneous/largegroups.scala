package miscellaneous

import scala.collection.mutable

class largegroups {
  def func(s: String): List[List[Int]] = {
    val map = mutable.Map[Char, mutable.ListBuffer[Int]]()
    //val results = mutable.Map[Char, mutable.ListBuffer[Int]]()
    val results = mutable.ListBuffer[List[Int]]()
    
    s.indices.foreach(idx => 
      idx match {
        //case idx if (!results.contains(s(idx))) => results += List(result(s(idx))._1)
        //case idx if (results.contains(s(idx))) => results += List(result(s(idx))._2)      
        case idx => if (map.contains(s(idx)) == false) {
                      map(s(idx))= mutable.ListBuffer(idx)
                     }
                    else map(s(idx)) += idx
    }
    )
    
   val result = map
       .filter(x => x._2.length >=3)
       .map(x => 
             (x._1, (x._2
                 .foldLeft(x._2(0),x._2(0))
                   {case ((min, max), e) => (math.min(min, e), math.max(max, e))
                   }
                 )
           )
      )
    results.toList
   //result.values.map(_._2)
   //result.get('x').map(x => x._1).toList
  }
}

object largegroups {
  def main(args: Array[String]): Unit = {
    val s = "abbxxxxzzy"
    
    val lg = new largegroups
    
    println(lg.func(s))
  }
}