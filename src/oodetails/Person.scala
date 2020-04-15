package oodetails

sealed trait MayBe[+A] {
  def flatMap[B](f: A => MayBe[B]): MayBe[B]

}

case class func1[+A](a: A) extends MayBe[A] {
  override def flatMap[B](f: A => MayBe[B]): MayBe[B] = f(a)
}

case object func2 extends MayBe[Nothing]{
  override def flatMap[B](f: Nothing => MayBe[B]) = func2
}

case class Person(name: String) {
  
}

object Person {
  def main(args: Array[String]): Unit = {

  val mothers = Map(Person("P") -> Person("MP"),
                     Person("MP") -> Person("MMP"),
                     Person("FP") -> Person("MFP"))

  val fathers = Map(Person("P") -> Person("FP"),
                     Person("MP") -> Person("FMP"),
                     Person("FP") -> Person("FFP"))                     

 def relation(p: Person, relationMap: Map[Person, Person]) = relationMap(p) match {
      case m => func1(m)
      case _ => func2
 }      
  
 val persons = List("P", "MP", "FP") map {a => Person(a)}
 val motherLineage = persons.map(relation(_, mothers))
 val fatherLineage = persons. map(relation(_, fathers))
        
                 
}
}
  


  