package oobasics

class Student(
    val firstName: String, 
    val lastName: String, 
    private var quizzes: List[Int] = Nil,  //when a constructor is mutable, make it private so external updates do not happen 
    private var assignments: List[Int] = Nil, 
    private var tests: List[Int] = Nil) {
  
  def addquiz(grade : Int) : Unit = quizzes ::= grade
  
  def quizAverage: Double = if(quizzes.isEmpty) 0.0 
                            else if (quizzes.length == 1) quizzes.head
                            else (quizzes.sum - quizzes.min).toDouble/ (quizzes.length - 1)
  def assignmentAverage : Double  = if(assignments.isEmpty) 0.0 
                                    else assignments.sum.toDouble/assignments.length
  def testAverage : Double = if(tests.isEmpty) 0.0 
                             else tests.sum.toDouble/tests.length
  def average: Double = quizAverage * 0.1 +   assignmentAverage * 0.5 + testAverage * 0.3
}