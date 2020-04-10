package oodetails


object Monad {
  def main(args: Array[String]) : Unit = {
    
    //for comprehension using Monad[List]
    
   //map applies transformation of monad content and returns monad content without changing external shape
   //ie, List remains List after we apply map
    def map[A,B](f: A => B): List[B] = ???
    
   //flatmap applies monad content and returns instance of same type with change in external shape
    //function passed to elements convert A -> M[B] and returns Monad
    def flatMap[A,B](f: A => List[B]): List[B] = ???
    
    val list = List("neo", "smith", "trinity")
    
    //converts each character of the string to its corresponding code
    val f: String => List[Int] = s => s.map(_.toInt).toList 
    
    //applies map on list elements
    //println(list map f)    //prints List(List(110, 101, 111), List(115, 109, 105, 116, 104), List(116, 114, 105, 110, 105, 116, 121))
    
    //applies flatmap on list elements
    //println(list flatMap f)  //prints List(110, 101, 111, 115, 109, 105, 116, 104, 116, 114, 105, 110, 105, 116, 121)
  }
}