package rtj

object TypeLevelPrgoramming {
  
  trait Nat
  class zero extends Nat
  class Succ[M <: Nat] extends Nat
  
  type one = Succ[zero]
  type two = Succ[one]
  type three = Succ[two]
  
  trait lessThan[A <: Nat, B <: Nat]
  object < extends lessThan {
    //implicit def validate[N <: Nat]: lessThan[zero, Succ[N]] = ???
    //def inductive[A <: Nat, B <: Nat]: lessThan[Succ[A], Succ[B]]  = ???
    def apply[A <: Nat, B <: Nat]: lessThan[A, B] = f
    
    val zerolessthantwo = <[zero, two]
    val threelessthanOne = <[three, one] 
    
  }
}