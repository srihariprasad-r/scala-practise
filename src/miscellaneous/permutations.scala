
package miscellaneous

class permutations {
  def permutations[T]: List[T] => Traversable[List[T]] = {
    case Nil => List(Nil)
    case xs => {
      for {
        (x, i) <- xs.zipWithIndex
        ys <- permutations(xs.take(i) ++ xs.drop(1 + i))
      } yield {
        x :: ys
      }
    }
  }
  
 //permutation using span method on List iterable 
 def perms[A](xs: List[A]) : List[List[A]] = xs match {
   case Nil => List(xs)
   case _ => for {
           x <- xs
           ; val (l,r) = xs span { x!= _ }
           ; ys <- perms(l ++ r.tail)    
       } yield (x :: ys)
  }

}

object permutations {
  def main(args:Array[String]):Unit = {
  val p1 = new permutations
  //println(p1.permutations(List(1, 2, 3)))
  //println(List(100,200,300).take(1) ++ List(100,200,300).drop(2))
  println(p1.perms(List(1,2,3)))
}
} 

