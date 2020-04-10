package oodetails

//Monad provides interface for composing values on container objects

sealed trait Option[A] {
  def map[B](f: A=> B) : Option[B]
  def flatMap[B](f: A=> Option[B]) : Option[B]
}

case class SomeFunc[A](a: A) extends Option[A] {
  def map[B](f: A=> B) : Option[B] = SomeFunc(f(a))
  def flatMap[B](f: A=> Option[B]) : Option[B] = f(a)
}

/**
*case class NoneFunc[A] extends Option[A] {
*  def map[B](f: A=> B) : Option[B] = None
*  def flatMap[B](f: A=> Option[B]) : Option[B] = None
*}
* 
*/

class Foo {
  def bar: Option[Bar] = ???
}

class Bar {
  def baz: Option[Baz] = ???
}

class Baz {
  def compute: Int = 33
}

object Monad {
  def main(args: Array[String]) : Unit = {
    
    //this method is a non-monad function as it is called on instance of same class
    def computeBaz(baz:Baz): Int = baz.compute     
    
    //this method uses map function to convert Option[Bar] instance to Option[Int] instance
    def computeBar(bar: Bar) : Option[Int] = bar.baz.map(computeBaz)    //mondaic function as it returns Option[Int]
    
    //this method uses flatmap as it already has monad function as input based on above method
    //flatMap uses function which converts A=> M[B] and returns M[B]
    def computeFoo(foo: Foo) : Option[Int] = foo.bar.flatMap(computeBar)
    
    //for comprehension using Monad[List]
    
   //map applies transformation of monad content and returns monad content without changing external shape
   //ie, List remains List after we apply map
    def map[A,B](f: A => B): List[B] = ???
    
   //flatmap applies monad content and returns instance of same type with change in external shape
    //function passed to elements convert A -> M[B] and returns Monad
    def flatMap[A,B](f: A => List[B]): List[B] = ???
    
    val list = List("neo", "smith", "trinity")
    
    //converts each character of the string to its corresponding code
    val f: String => List[Int] = s => s.map(_.toInt).toList 
    
    //applies map on list elements
    //println(list map f)    //prints List(List(110, 101, 111), List(115, 109, 105, 116, 104), List(116, 114, 105, 110, 105, 116, 121))
    
    //applies flatmap on list elements
    //println(list flatMap f)  //prints List(110, 101, 111, 115, 109, 105, 116, 104, 116, 114, 105, 110, 105, 116, 121)
    
    /*************************************************************************************************/
    //flatMaps can be rewritten in for comprehension as below
    
    //Step:1 - rearrange the flatMap expression into for comprehension
    for {        //prints List(110, 101, 111, 115, 109, 105, 116, 104, 116, 114, 105, 110, 105, 116, 121)
      a <- list
      b  <- f(a) 
    } yield b    
    
    //Step-2: Decompose first <- into flatMap and last <- will be mapped as we have yield
    list.flatMap { a => 
      f(a).map { b => b } 
      }     
    
    //Step-3 : Removed map which is on identity function which return fa.map(identity) = fa
    list.flatMap { a => f(a) }
    
    //Step4: a=> f(a) can be rewritten as f by law _ => f(_) and '_' is placeholder syntax
    list flatMap f

    /*************************************************************************************************/
    //map can be rewritten in for comprehension as below    
    
    //Step-1: Map can be written with one generator and yield which produces Monad of same shape
    for {
      a <- list
    } yield(f(a))
    
    //Step-2: as there is only generator with yield, we can directly convert as map and pass each element to function f
    list.map{ a => f(a) }
    
    //Step-3: Based on identity rule, removed unnecessary params
    list map f

    /*************************************************************************************************/
    //Examples of complex for comprehension converted to flatmap/map examples
    
    val powertable = for {
      x <- 2 to 3
      y <- (3 :: 4:: Nil) 
    }yield List(x, y, Math.pow(x, y))
    
    //println(powertable)    //prints Vector(List(2.0, 3.0, 8.0), List(2.0, 4.0, 16.0), List(3.0, 3.0, 27.0), List(3.0, 4.0, 81.0))
    
    (2 to 3) flatMap { x => 
      (3 :: 4:: Nil) map{ y =>
        (x, y)
      } map { case (x, y) => List(x, y, Math.pow(x, y)) }
    }
    
  }
}