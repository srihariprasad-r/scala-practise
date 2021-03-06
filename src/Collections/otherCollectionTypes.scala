package Collections

object otherCollectionTypes {
  
  def main(args:Array[String]): Unit = {

  /*****************************************************************************************/  
  //Set collection - Trait, sets are not ordered  
    
  val a: Set[Int] = Set(1,2,3)
  //a += 4        //+= is not member of Immutable set
  //println(a)      //prints Set(1, 2, 3)
  
  var b: Set[Int] = Set(1,2,3)
  b = b + 4
  //println(b)      //prints Set(1, 2, 3, 4)
  
  //indexing in set, which check if element is present in this set
  //below execution internally call b.apply(2)
  //print(b(2)) //prints true
  
  //in below example, two sets are added to list and flattened out 
  //This return list collection
  val c = List(a,b)
  //print(c.flatten)        //prints List(1, 2, 3, 1, 2, 3, 4)
  
  //below prints only 2 values which are distinct even though there are three elements involved in set
  //println(Set(1,2,3).map(x => x %2))   //prints Set(1, 0)

  /*****************************************************************************************/
  //Seq collection examples
  
  val s: Seq[Int] = Seq(1,2,3,4, 0)
  val t: Seq[Boolean] = Seq(true, false, true)
  
  //println(s.zip(t))  //prints List((1,true), (2,false), (3,true))
  
  val m : Map[Int, Boolean] = s.zip(t).toMap
  //println(m)    //prints Map(1 -> true, 2 -> false, 3 -> true)
  
  println(m.filter {
    case(x, y) => y == true 
  })          //prints Map(1 -> true, 3 -> true)
  
  //function to get maximum value every 2 elements given a sequence
  val seq = Seq(1,2,3,4,5)
  val sliding = seq.sliding(2).toList  //prints List(List(1, 2), List(2, 3), List(3, 4), List(4, 5))
  //println(sliding map {l => l.max })    //prints List(2, 3, 4, 5)
  
  val x = Seq(0,0.1,0.2) zip Seq(1.0,2.0,3.0)
  //println(x)      //prints List((0.0,1.0), (0.1,2.0), (0.2,3.0))
  //println(x.map { case (x,y) => x- y})     //prints List(-1.0, -1.9, -2.8)
  
  //below function will get count of elements which have a[i] > a[i+1]
  val a1 = s.drop(1)
  //println(a1)      //prints List(2, 3)
  val c1 = s.zip(a1)
  //println(c1)       //prints List((1,2), (2,3))
  //println(c1 count { case (x,y) => x > y})    //prints 1
  //above function can also be written as below
  s zip (s drop(1)) count { case(x,y) => x > y} 
      
  //print multiplication table of 3 using map implementation
  val m1 = List(1,2,3)
  //println(m1.map{i => m1.map { j => ((i, j), j*i )}}.flatten.toMap)
  //prints Map((3,1) -> 3, (1,1) -> 1, (3,2) -> 6, (1,3) -> 3, (2,2) -> 4, (3,3) -> 9, (2,3) -> 6, (1,2) -> 2, (2,1) -> 2)     
  
  //same implementation using flatmap which is map + flatten
  //println(m1.flatMap{ i => m1 map {j => (i,j) -> j*i}}.toMap)
  
  //convert the below sequence to Tuples with true when element following is greater than current element
  val ex2 = Seq(1,3,2,4)
  val dropex2 = ex2.drop(1)
  //println(ex2.zip(dropex2))  //prints List((1,3), (3,2), (2,4))
  //println(ex2.zip(dropex2).map{case(a,b) => (a -> (a < b))}.toMap)  //prints Map(1 -> true, 3 -> false, 2 -> true)
  
  //convert sequence of digits to integer digits using tail recursion
  def seqToInt(s: Seq[Int], acc: Int): Int = {
    if (s.isEmpty) acc
    else seqToInt(s.drop(1), 10*acc + s.head)
  }
    
  //println(seqToInt(Seq(3,4,5,6,7), 0))    //34567
  
  //convert integer to sequence of digits
  val digitToSeq= Iterator.iterate((3341,0)){case (m,_) => (m/10, m%10)}.takeWhile{case(x, y) => x > 0 || y > 0 }.drop(1).toList.reverse.map(_._2)
  //println(digitToSeq)      //prints List(3, 3, 4, 1)
  
  //write function which gets sum of previous elements
  val scanExample = ex2.scan(0){(x,y) => x + y} 
  //println(scanExample) //prints List(0, 1, 4, 6, 10) 
  
  //below function will iterate from 1 through x and stops when f(x) == 1000 and returns count of items which caused overflow 
  val a2 = Iterator.iterate(1){a => 2*a + 1}.takeWhile{_ <= 1000}.toList
  //println(a2)    //prints List(1, 3, 7, 15, 31, 63, 127, 255, 511)
  
  //get last element in seq
  val s2 = Seq(1,10,5,20,1000)
  def func2(a: Seq[Int]): Int = a match {
    case Seq(x) => x
    case _ => func2(a.drop(1))
  }  
  //println(func2(s2))      //prints 1000
  
  //below code will fetch the third largest element
  //println(s2.zip(s2.drop(1)).map{case (x,y) => if (x > y) x else y}.distinct.take(1))
  
  //below is recursive function to fetch third maximum element  
  def func3(a:List[Int], max : Int, k: Int): Int = (a, k) match {
    case (a,  k) if k == 2 => a.reduce((x,y) => if (x > y) x else y)
    case (a, _) => 
      val max = a.reduce((x,y) => if (x > y) x else y)
      func3(a.takeWhile{ _< max}, max, k+1) 
  }
  
  //println(func3(s2.toList,Int.MaxValue,0))    //prints 10
  
 //write code to implement binary search on sorted Array[Int]
  //return smaller number closer to given number
  val array: Array[Int] = Array(1,2,5,10,20)
  
  def binarySearch(a: Array[Int] , x:Int): Int = a match {
    case Array(z) => z
    case _ => {
      val l: Int = a.length/2
      val (left, right) = a.splitAt(l)
      if (x > a(l)) {        
        binarySearch(right, x)
      } else {
        binarySearch(left, x)        
      }
    }
  }
    
    //println(binarySearch(array, 15))  //prints 10
  
}
}