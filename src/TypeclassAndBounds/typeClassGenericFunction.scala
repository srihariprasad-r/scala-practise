package TypeclassAndBounds

class typeClassGenericFunction {
  //below is generic function take A as type parameter
  
  //type parameters can be used only for functions/variables and not for classes
  def addToList[A](a: A, b: List[A]): List[A] = {
    val middle: Int = b.length/2
    val splitList: (List[A], List[A]) = b.splitAt(middle)
    val finalList:List[A] = splitList._1 ::: (a::splitList._2)    
    finalList
  }
}


class Dog(n: String) {
  override def toString = n 
  def printName: String = n
}


object typeClassGenericFunction{
  def main(args: Array[String]): Unit = {
    val list1 = List(1,2,3,4,5)
    val list2 = List("a", "b","c","d","e")
    
    val c = new typeClassGenericFunction
    println(c.addToList(7, list1))    //prints List(1, 2, 7, 3, 4, 5)
    //below works for string as well
    println(c.addToList("f", list2))  //prints List(a, b, f, c, d, e)
    
    //same methode works for instances as well
    println(c.addToList(new Dog("dog-3"), List(new Dog("dog-1"),new Dog("dog-2"))))  
    //prints List(dog-1, dog-3, dog-2)
    
    
  }
}