package polymorphism

class SampleCode {
  
  def sumValues(base: Double, x:Double):Double = {
    if (x < 1) base else 1 + sumValues(base, x-1) 
  }

  //full implementation
  def productValues(base: Double, x:Double):Double = {
    if (x < 1) base else 1 * productValues(base, x-1) 
  }
  
  //abstraction
  def combineValues(x:Int, base:Double ,op: (Double, Double) => Double):Double = {
    if (x < 1) base else op(1.0, combineValues(x-1, base,op))
  }
  
}

object SampleCode {
  def main(args:Array[String]) :Unit = {
    val pmorph = new SampleCode()    
    //val op = pmorph.productValues(1.0, 10.0)
    val productResult: Double = pmorph.combineValues(1, 3.0,pmorph.productValues)
    println(productResult)
    val sumResult: Double = pmorph.combineValues(1, 1.0,pmorph.sumValues)    
    println(sumResult)
  }
  
}