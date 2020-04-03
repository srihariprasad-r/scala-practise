package TypeclassAndBounds

class parentClass[A]{
  def func: Unit = println("I am in parentClass")
}

class childClass extends parentClass{
  override def func: Unit = println("I am in childClass1")
}

class childClass2 extends childClass{
  override def func: Unit = println("I am in childClass2")
}

//error occured when this class had just type parameter of A
//to fix the error, we add A <: childClass , where <: => represents type A is upper bound to childClass
//type A can take any either is base Class(which is "childClass" or any of its subclasses
class coVarUpperBound[A <: childClass](a:A){
  def covarFunc  = a.func   //value func is not member of type parameter A
}

//class coVarLowerBound[A >: childClass](a:A){
//  def covarFunc  = a.func 
//}


object typesOfBounds {
  def main(args:Array[String]): Unit = {
    val p = new parentClass
    val c = new childClass
    val c2 = new childClass2 
    
    //instantiate the covariance class with childClass or its subtypes
    val coVariance = new coVarUpperBound(c)
    println(coVariance.covarFunc)  //prints I am in childClass1
    
    //works!
    val coVariance2 = new coVarUpperBound(c2)
    println(coVariance2.covarFunc)  //I am in childClass2  
        
  }
  
}