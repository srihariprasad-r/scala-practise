package rtj

class Person(val name: String) {
  //import scala.runtime.ScalaRunTime.stringOf
  def calculateAge(n: Int): Int = n
  def isMale(gender: Boolean): Boolean = gender
  def parentName(p: Person): String = p.name
}

class Parent(val father: Person = null, val mother: Person = null) extends Person("") {
  def this(father: Person) = this(father, null)
  //unapply case match
  def parent(): Boolean = this match {
    case Parent(father, null) => isMale(true)
    case Parent(null, mother) => isMale(false)
    case Parent(father, mother) => isMale(true)
  }
  def getParentName(p: Person): String = parentName(p)
}

object Parent{
  def unapply(p: Parent): Option[(Person, Person)] = Some(p.father, p.mother)
}

def main(args: Array[String]): Unit = {
  val fp1 = new Person("FP1")
  val mp1 = new Person("MP1")
  val p1 = new Parent(fp1, mp1)
  println(p1.parent())
  println(p1.getParentName(mp1))
  println(p1.calculateAge(10))
}