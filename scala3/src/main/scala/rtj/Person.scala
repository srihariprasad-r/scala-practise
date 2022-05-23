package rtj

class Person(val name: String) {
  //import Person._
  //import scala.runtime.ScalaRunTime.stringOf
}

class Parent(val father: Person = null, val mother: Person = null){
  import Person._
  def parent(): Boolean = this match {
    case father if mother == null => Person.isMale(true)
    case mother if father == null => Person.isMale(false)
    case _ if father != null && mother != null => Person.isMale(true)
    case null => false
  }
  def getParentName(p: Person): String = Person.parentName(p)
}

object Person extends App{
  def calculateAge(n: Int): Int = n
  def isMale(gender: Boolean): Boolean = gender
  def parentName(p: Person): String = p.name
}

def main(args: Array[String]): Unit = {
  val fp1 = new Person("FP1")
  val mp1 = new Person("MP1")
  val p1 = new Parent(fp1, mp1)
  println(p1.parent()) //Array(FP1, MP1)
  println(p1.getParentName(mp1))
  println(Person.calculateAge(10))
}