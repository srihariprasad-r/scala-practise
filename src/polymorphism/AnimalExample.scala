package polymorphism

class AnimalExample(color: String) {
  val animalColor = color
  def sound = { println("No sound") }
}

trait Tricks {
  def trickName
}

//use abstract class when there is no need of instantiation of objects 
abstract class Animal(color:String) {
  def sound:Unit
  val animalComor = color
}

//tried to extend 2 classes, but throws error
//traits can be mixed with class using with keyword
class Cat(val color: String, tricks:List[String]) extends AnimalExample(color) with Tricks //extends Tricks(trick)
{
  override val animalColor = color 
  def trickName = println(tricks)
}

class Dog(val color: String) extends AnimalExample(color) {
  override def sound =  {println("I bark")} 
  def newMethod = { println("Hi")}
}

class myPet(a: AnimalExample){
  def description: Unit =  {println("My pet is " + a.toString() + " and it has color: " + a.animalColor)} 
}

object AnimalExample{
  def main(args: Array[String]): Unit = {
    //val an = new Animal("black")    //this throws error as class is abstract
    
    val c = new Cat("blue", List("jump", "sit"))
    println(c.animalColor)  //prints blue
    println(c.trickName)  //List(jump, sit)
    val d = new Dog("black")
    println(d.animalColor)  //prints black
    println(d.sound)   //prints "I bark"
    
    val a = new myPet(d)
    println(a.description)   //prints "My pet is polymorphism.Dog@5f184fc6 and it has color: black"
    
  }
}