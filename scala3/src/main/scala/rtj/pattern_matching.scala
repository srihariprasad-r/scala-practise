package rtj

object pattern_matching {
  trait Expr
  case class Number(n: Int) extends Expr
  case class Sum(e1: Expr, e2: Expr) extends Expr
  case class Prod(e1: Expr, e2: Expr) extends Expr

  def show(e: Expr): String = e match {
    case Number(n) => s"${n}"
    case Sum(e1, e2) => {
      def nestedSum(exp: Expr): String = exp match {
        case Number(_) => show(exp)
        case Prod(_, _) => show(exp)
        case _ => "(" + show(exp) + ")"
      }
      nestedSum(e1) + " + " + nestedSum(e2)
    }
    case Prod(e1, e2) => show(e1) + " * " + show(e2)
  }


  def main(args: Array[String]): Unit = {
    println(show(Sum(Sum(Number(1), Number(2)), Prod(Number(4), Number(1)))))  //(1 + 2) + 4 * 1
  }
}
