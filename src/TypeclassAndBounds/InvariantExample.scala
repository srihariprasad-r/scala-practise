package TypeclassAndBounds

class zooAnimal

class Animal(food: String) {
   val eatingHabit: String = food 
}

class Lion(food: String) extends Animal(food){
  override def toString = food
  override val eatingHabit: String = food 
}

class Tiger(food: String) extends Animal(food)

//below is normal class implementation
class Zoo(animal: Animal){
  //this class expects instances of  Animal
  val eatingHabit: String = animal.eatingHabit
}

//below is type class implementation with generic type 'A'.
//adding '+' makes it covariant, if B is subtype of A then Class[B] is subtype of Class[A]
class typeZoo[+A](animal: A){
  //this is type class expects instances of any type A and returns instances of same type
  //val eatingHabit: String = animal.eatingHabit  
}

//below type class accepts instances from typeZoo class which are instances of Animal
class areaZoo(z: typeZoo[zooAnimal]) {
   //val eatingHabit: String = z.eatingHabit
}

class typeLion extends zooAnimal

object InvariantExample {
  def main(args: Array[String]): Unit = {
    //normal class without any Type information
    val zooAnimal1 = new Zoo(new Lion("Meat")) 
    println(zooAnimal1.eatingHabit)    //prints "Meat"!
    
    //error: type mismatch - Invariant type - DEFAULT behavior
    //val zooAnimal2 = new areaZoo(new typeZoo[Lion](new Lion("Meat")))
    //println(zooAnimal2)   

    //below code works when instantiated with zooAnimal class
    val zooAnimal3 = new areaZoo(new typeZoo[zooAnimal] (new zooAnimal)) 
    println(zooAnimal3)      //prints "TypeclassAndBounds.areaZoo@5f184fc6"   

    //below works after changing the class to covariant
    val zooAnimal4 = new areaZoo(new typeZoo[typeLion](new typeLion)) 
    println(zooAnimal4)       //prints TypeclassAndBounds.areaZoo@3feba861
    
  }
  
}





