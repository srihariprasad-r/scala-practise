package rtj

//tried on https://scastie.scala-lang.org/
object TypeLevelProgramming {

  trait Nat
  class zero extends Nat
  class Succ[M <: Nat] extends Nat

  type one = Succ[zero]
  type two = Succ[one]
  type three = Succ[two]

  trait <[A <: Nat, B <: Nat]
  object < {
    //given basic with type N, creates instance of <[zero, Succ[N]] with implementation in {}
    given validate[N <: Nat]: <[zero, Succ[N]] with {}
    given inductive[A <: Nat, B <: Nat](using <[A, B]): <[Succ[A], Succ[B]] with {}
    def apply[A <: Nat, B <: Nat](using lt: <[A, B]): <[A, B] = lt

    val zerolessthantwo = <[zero, two]
    //no implicit argument of type TypeLevelProgramming.three < TypeLevelProgramming.one was found for parameter lt of method apply in object <.:
    val threelessthanOne = <[three, one]
  }
}