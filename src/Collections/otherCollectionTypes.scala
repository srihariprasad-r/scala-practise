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
  println(m1.flatMap{ i => m1 map {j => (i,j) -> j*i}}.toMap)
}
}