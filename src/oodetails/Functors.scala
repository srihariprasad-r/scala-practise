package oodetails



//Functors are abstraction provided for type constructors and is not applicable for primitive types such as Int
trait Functors[F[_]] {
  
  //below definition maps a type constructor with type F[A] and applies a function to covert to F[B]
  def map[A, B](fa: F[A])(f:A=> B): F[B] 
  
}

//Functors need to obey laws of identity and composition
trait FunctorLaws{
  
  //identity function takes a type constructor and proves to be identical after returning same element
  def identity[F[_], A](fa: F[A])(implicit f: Functors[F]) = f.map(fa)(a=> a) == fa
  
  //composition functions take type constructor with type A and converts to C through A => B & B => C
  def composition[F[_], A, B, C](fa: F[A], f: A=> B, g: B=> C)(implicit F: Functors[F]) =
    F.map(F.map(fa)(f))(g) == F.map(fa)(f andThen g)
    
}

object Functors {
  
  implicit val listFunctor: Functors[List] = new Functors[List] {
    def map[A, B](fa: List[A])(f:A=> B): List[B] = fa.map(f)
  }
  
  
}