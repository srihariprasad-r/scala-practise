package rtj

class Person(val name: String) {
  //import scala.runtime.ScalaRunTime.stringOf
  def calculateAge(n: Int): Int = n
  def isMale(gender: Boolean): Boolean = gender
  def parentName(p: Person): String = p.name
}

class Parent(val father: Person = null, val mother: Person = null) extends Person("") {
  //auxillary constructor
  def this(father: Person) = this(father, null)
  def parent(): Boolean = this match {
    case father if mother == null => isMale(true)
    case mother if father == null => isMale(false)
    case _ if father != null && mother != null => isMale(true)
    case null => false
  }
  def getParentName(p: Person): String = parentName(p)
}

object Person extends App{}

def main(args: Array[String]): Unit = {
  val fp1 = new Person("FP1")
  val mp1 = new Person("MP1")
  val p1 = new Parent(father=fp1)
  println(p1.parent())
  println(p1.getParentName(mp1))
  println(p1.calculateAge(10))
}