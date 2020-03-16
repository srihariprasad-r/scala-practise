package oobasics

object Gradebook {
  def main(args: Array[String]): Unit = {
    val students = List(new Student("Jane","Doe"), new Student("John","Doe"))
    for (i <- students) printStudent(i)
  }
  
  def printStudent(s: Student): Unit = {
    println(s.firstName + " " + s.lastName)
    println("Grade = " + s.average)
    println(s.tests.mkString(","))
  }
  
}