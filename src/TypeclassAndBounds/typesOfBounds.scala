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

class contraClass[+A]{
  //below implementation causes issues as class is co-variant and type parameter passed as input 
  //def func(a:A, list: List[A]):List[A]= {a::list}
  
  //below implementation works after we add Upper bound
  def func[A <:contraChildClass](a:A, list: List[A]):List[A]= {a::list}
}

class contraChildClass extends contraClass{
  def somefunc:Unit= println("executing childclass")
}


class contraChildClass2 extends contraChildClass{
  override def somefunc:Unit = println("executing childclass2")
}


class coVarClass[-A]{
  //below implementation causes issues as class is contra-variant and return type parameter passed 
  //def func(a:A):List[A] = List(a):::Nil
  
  //below implementation works after we add lower bound
  def func[A >:coVarChildClass](a:A):List[A] = List(a):::Nil
}

class coVarChildClass extends coVarClass{
  def somefunc:Unit= println("executing childclass")
}

object typesOfBounds {
  def main(args:Array[String]): Unit = {
    val p = new parentClass
    val c = new childClass
    val c2 = new childClass2       
    
    //instantiate the covariance class with childClass or its sub-types
    val coVariance = new coVarUpperBound(c)
    println(coVariance.covarFunc)  //prints I am in childClass1
    
    //works!
    val coVariance2 = new coVarUpperBound(c2)
    println(coVariance2.covarFunc)  //I am in childClass2
    
    //val coV = new contraClass
    val list = List(new contraClass, new contraClass[contraChildClass], new contraClass[contraChildClass2])
    println(list)  //prints List(TypeclassAndBounds.contraClass@2f4d3709, TypeclassAndBounds.contraClass@4e50df2e, TypeclassAndBounds.contraClass@1d81eb93)
        
    
    val contraV = new coVarClass
    val list2 = contraV.func(2)
    println(list2)  //prints List(2)    
  }
  
}