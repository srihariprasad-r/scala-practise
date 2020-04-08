package oodetails

object introFunctions {
  def main(args: Array[String]):Unit = {
    
    /************************************************************************************************/
    
    //Higher order functions
    def loggerFunc(x: String): (String => Unit) = {
      t => println(s"$x returned $t")
    }
    
    //below value stored function location in memory and need additional parameter 't' to return output
    val statusLogger = loggerFunc("logger completed")
    //println(statusLogger("Success"))  //prints "logger completed returned Success"
    
    //below code as works!
    //println(loggerFunc("logger completed")("Success"))
    
    /************************************************************************************************/
    
    //Disjunction Type - Either[A, B]
    //above function can be written using Either[String, Int] which either prints error or returns result
    def disjointLoggerFunc(x: Either[String, Int]): Int = x match {
      case Left(a) => println(s"Error raised: $a"); -1      //this expression prints a message and return Int (-1)
      case Right(res) => res    
    }
    
    //println(disjointLoggerFunc(Left("Logger failure"))) //prints "Error raised: Logger failure  -1"
    
    //below function call will execute Right(..) case expression
    //println(disjointLoggerFunc(Right(32)))    //prints 32
    
    //To create more general disjunct types, we will mix in traits and case classes
    
    sealed trait MyType
    final case class inputAsList(a: List[Int]) extends MyType
    final case class inputAsInt(a: Int) extends MyType
    final case class inputAsBoolean(a: Int, x: Boolean) extends MyType    
    
    def genericDisjoint(x: MyType) = x match {
      case inputAsList(z) => z.head
      case inputAsInt(m) => m*10
      case inputAsBoolean(n, b) => !b
    }
    
    //below will execute the function which are generic on Types
    //println(genericDisjoint(inputAsList(List(1,2,3))))    //prints 1
    //println(genericDisjoint(inputAsInt(30)))              //prints 300
    //println(genericDisjoint(inputAsBoolean(30, true)))    //prints false
    
    //Other common type of disjunction is Option[T] which has Some(x) & None as Left/Right
    //below is example which divides a number by other and returns result using Option
    
    def divisionByOption(x: Int, y: Int) : Option[Double] = (x,y) match {
      case (_, 0) => None
      case (0, _) => Some(0)      
      case _ => Some(x/y)
    }
    
    val result: Unit = divisionByOption(1, 0) match {        //this function prints "Error occured"
      case Some(x) => println(x)            //similar to Left(x) in Either[T] 
      case None => println("Error occured")    //similar to Right(x) in Either[T], and is case object extending Nothing
    }

    /************************************************************************************************/
    
    //Curry Howard proposition
    //vA: A => A            def identity[A](x:A): A => x
    //vA: A => 1            def toUnit[A](x:A):  Unit => ()  
    //vAvB: A => A + B      def either[A,B](x: A): Either[A,B] = Left(x)        //'+' means OR (Either)
    //vAvB: A x B => A      def tuple[A,B](p:(A,B)): A => p._1                  //'x' means AND (tuple)
    //vAvB: A => (B => A)   def implicit[A](x:A): B => A = (y: B) => x
    
    
   
  }
}

 