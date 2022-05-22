package rtj

class Person(val name: String) {
  import Person._
  //import scala.runtime.ScalaRunTime.stringOf
  def parent(): String = {
    val s = this.name
    s.split(" ").toList match {
      case x :: y :: Nil => s"Father: ${x} Mother: ${y}"
      case _ => "None"
    }
  }
}

object Person extends App{
  def calculateAge(n: Int): Int = n
  def isMale(gender: Boolean): Boolean = gender
  def apply(father: Person, mother: Person) = {
    val child = s"${father.name} ${mother.name}"
    new Person(child)
  }
}

def main(args: Array[String]): Unit = {
  val fp1 = new Person("FP1")
  val mp1 = new Person("MP1")
  val p1 = Person(fp1, mp1)
  println(p1.parent()) //Array(FP1, MP1)
  println(Person.calculateAge(10))
}