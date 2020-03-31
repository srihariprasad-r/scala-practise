package polymorphism
import scala.language.implicitConversions

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
class Cat(val color: String, val tricks:List[String]) extends AnimalExample(color) with Tricks //extends Tricks(trick)
{
  override val animalColor = color 
  def trickName = println(tricks)
}

class Dog(val color: String) extends AnimalExample(color) {
  override def sound =  {println("I bark")} 
  def newMethod = { println("Hi")}
  def food(morning: String)(implicit evening: String) = { println("I have " + morning + " and: " + evening)}
  def enoughFood(implicit quantity: String) = println("I had "+ quantity + " cups!")
}

class myPet(a: AnimalExample){
  def description: Unit =  {println("My pet is " + a.toString() + " and it has color: " + a.animalColor)} 
}

object AnimalExample{
  def main(args: Array[String]): Unit = {
    //val an = new Animal("black")    //this throws error as class is abstract
    
    //below defines implicit variables
    implicit val animalFood : String = "Fasting all evening!" 
    implicit def foodQuantity (a: Int) = a.toString
    
    //code implementation
    val c = new Cat("blue", List("jump", "sit"))
    println(c.animalColor)  //prints blue
    println(c.trickName)  //List(jump, sit)
    val d = new Dog("black")
    println(d.animalColor)  //prints black
    println(d.sound)   //prints "I bark"
    
    //below proves implicit conversion
    println(d.food("Pedigree")) //prints "I have Pedigree and: Fasting all evening!" 
    
    //below takes integer as input and implicitly converts to string
    println(d.enoughFood(20))  //prints "I had 20 cups!"
    
    val a = new myPet(d)
    println(a.description)   //prints "My pet is polymorphism.Dog@5f184fc6 and it has color: black"
    
  }
}