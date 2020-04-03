package TypeclassAndBounds


class Forest(name: String){
  def someImplementation: Unit = println(s"Inside Forest class, printing the name of forest: $name")
}

class LionAsAnimal(name: String) extends Forest(name){
  override def someImplementation: Unit = println(s"Inside Lion class, printing the name: $name!")
}

class WhiteLion(name: String)  extends LionAsAnimal(name){
  override def someImplementation: Unit = println(s"Inside whiteLion class, printing the name: $name!")
}

class TigerAsAnimal(name: String) extends Forest(name){
  override def someImplementation: Unit = println(s"Inside Lion class, printing the name: $name!")
}

//class DessertLion extends LionAsAnimal

//class TigerAsAnimal extends Forest

//class BengalTiger extends TigerAsAnimal

//class SiberianTiger extends TigerAsAnimal

class ForestZoo[+A](f:A){      //covariant implementation
  def function1:A = f        //when class is covariant, it can have functions return type of A
  //def function2(a: A) :A       //but it cannot take input arguments of same type
}

class typeAnimal(d: ForestZoo[LionAsAnimal])  //class accepts constructor with LionAsAnimal as type parameter

class contraZoo[-A](f:A){      //contravariant implementation
  //def function1:A = f      //when class is contravariant, it can't have functions which returns type of A
  def function2(a: A) = ???    //but they can get input arguments 
}

class typeContraAnimal(d: contraZoo[Forest])


object DirectionsofVariants {
  def main(args: Array[String]) : Unit = {
    val forest = new Forest("Sahara")
    //println(forest.someImplementation)
    
    val lion = new LionAsAnimal("Lion")    //this instance extends Forests class
    //println(lion.isInstanceOf[LionAsAnimal])  //prints true
    //println(lion.isInstanceOf[Forest])       //prints true
    //println(lion.someImplementation)         //prints Inside Lion class, printing the name: Lion!
    
    val tiger = new TigerAsAnimal("Tiger")
    //println(tiger.asInstanceOf[Forest])    
    //println(tiger.someImplementation)    //prints Inside Lion class, printing the name: Tiger!
    
    val whiteLion = new WhiteLion("White")
    //println(whiteLion.someImplementation)
    
    //below code works as base class is passed as argument!
    val covariantZoo1 = new typeAnimal(new ForestZoo (lion))
    //println(covariantZoo1)  //prints TypeclassAndBounds.ForestZoo@5f184fc6

    //val covariantZoo2 = new typeAnimal(new ForestZoo (forest))
    //println(covariantZoo2)  //prints TypeclassAndBounds.ForestZoo@5f184fc6
    
    //below throws error as it is covariant and only its base class and subclass are accessible
    //val covariantZoo3 = new typeAnimal(new ForestZoo (tiger))
    //println(covariantZoo3)  //prints TypeclassAndBounds.ForestZoo@5f184fc6
    
    //below code works as child classes are passed as argument!    
    val covariantZoo4 = new typeAnimal(new ForestZoo(whiteLion))
    //println(covariantZoo4)  //TypeclassAndBounds.typeAnimal@3feba861    

    //below throws error as it is contravariant and only its base class and superclass are accessible, subclass is not
    //val contravariantZoo5 = new typeContraAnimal(new contraZoo[LionAsAnimal](lion))
    //println(contravariantZoo5)  //TypeclassAndBounds.typeAnimal@3feba861       
    
    //below works!
    val contravariantZoo6 = new typeContraAnimal(new contraZoo[Forest] (forest))
    //println(contravariantZoo6)  //TypeclassAndBounds.typeContraAnimal@5b480cf9         
  }
}