package oodetails

object introFunctions {
  def main(args: Array[String]):Unit = {

    //Higher order functions
    def loggerFunc(x: String): (String => Unit) = {
      t => println(s"$x returned $t")
    }
    
    //below value stored function location in memory and need additional parameter 't' to return output
    val statusLogger = loggerFunc("logger completed")
    //println(statusLogger("Success"))  //prints "logger completed returned Success"
    
    //below code as works!
    //println(loggerFunc("logger completed")("Success"))
    
    //Disjoint Type - Either[A, B]
    //above function can be written using Either[String, Int] which either prints error or returns result
    def disjointLoggerFunc(x: Either[String, Int]): Int = x match {
      case Left(a) => println(s"Error raised: $a"); -1      //this expression prints a message and return Int (-1)
      case Right(res) => res
    }
    
    println(disjointLoggerFunc(Left("Logger failure"))) //prints "Error raised: Logger failure  -1"
    
    //below function call will execute Right(..) case expression
    println(disjointLoggerFunc(Right(32)))    //prints 32
   
  }
}

