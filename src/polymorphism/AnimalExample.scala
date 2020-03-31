package polymorphism

class AnimalExample(color: String) {
  val animalColor = color
  def sound = { println("No sound") }
}

class Cat(val color: String) extends AnimalExample(color) {
  override val animalColor = color 
}

class Dog(val color: String) extends AnimalExample(color) {
  override def sound =  {println("I bark")} 
}

class myPet(a: AnimalExample){
  def description: Unit =  {println("My pet is " + a.toString() + " and it has color: " + a.animalColor)} 
}

object AnimalExample{
  def main(args: Array[String]): Unit = {
    val d = new Dog("black")
    println(d.animalColor)  //prints black
    println(d.sound)   //prints "I bark"
    
    val a = new myPet(d)
    println(a.description)   //prints "My pet is polymorphism.Dog@5f184fc6 and it has color: black"
    
  }
}