package rtj

class Person(val name: String) {
  import Person._
  def name(fname: Person): Person = ???
}

object Person extends App{
  def calculateAge(n: Int): Int = n
  def isMale(gender: Boolean): Boolean = gender
  def apply(name: String) = new Person(name)
}

def main(args: Array[String]): Unit = {
  val fp1 = Person("FP1")
  //val mp1 = Person("MP1")
  //println(Person.parent(fp1, mp1))
  println(Person.calculateAge(10))
}
