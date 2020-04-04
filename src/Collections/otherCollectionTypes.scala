package Collections

object otherCollectionTypes {
  
  def main(args:Array[String]): Unit = {
    
  //Set collection - Trait, sets are not ordered  
  val a: Set[Int] = Set(1,2,3)
  //a += 4        //+= is not member of Immutable set
  println(a)      //prints Set(1, 2, 3)
  
  var b: Set[Int] = Set(1,2,3)
  b = b + 4
  println(b)      //prints Set(1, 2, 3, 4)
  
  //indexing in set, which check if element is present in this set
  //below execution internally call b.apply(2)
  print(b(2)) //prints true
  
  //in below example, two sets are added to list and flattened out 
  //This return list collection
  val c = List(a,b)
  print(c.flatten)        //prints List(1, 2, 3, 1, 2, 3, 4)

  print(c)
  
}
}