package oodetails

object introToLists {
  def main(args:Array[String]):Unit = {
    val list0 = List() //creates an empty List
    val list1 = List(2)
    
    //auto fill elements with default values based on size
    val list2 = List.fill(6)(0)
    
    //fill values on given based on function literal
    val list3 = List.tabulate(5)(x=> x*2)
    
    //similar to list1 union list2
    val list4 = list2 ++ list3
    
    //append elements before & after 
    val list5 = 3 +: list2  
    val list6 = list2 :+ 6
    
    //foldleft
    val list7 = (0 /: list3)((acc, elem) => (acc+elem))
    val countList7 = (0 /: list3)((acc, elem) => (acc+1))
    val valAndCountList7 = (Tuple2(0,0) /: list3)((acc, elem) => (acc._1+1, elem+acc._2))
    val maxMinListElement = list3.foldLeft(list3(0), list3(0)) {case ((max, min),e) => 
              (math.max(max, e), math.min(min, e))}         
    
    //foldright
    val list8 = (list3 :\ 410)((acc,elem) => (acc+elem))
    
    val sampleString = List('h','e', 'l', 'l', 'o')
    
    val stringList = List('h','e','l','l','o').addString(new StringBuilder)
    
    sampleString match {
      case h :: t => println(h)
      case _ => println("catch all")
    }
    
    //iterative programming
    def isPalindrome(str : String): Boolean = {
      val strLen = str.length()
      for (i <- 0 until strLen/2) {
          if (str(i) != str(strLen-1)) false }
      true
    }     

   //using reduceLeft function 
   def isPalindrome2(s: String) = {
       (for (x <- 0 to s.length/2) yield (s(x) == s(s.length - x - 1)))
       .reduceLeft((acc, n) => acc && n)
   }    
    
    //val str = "racecar"
    //print(isPalindrome2(str)) 
   
   //function to count the occurance of element and return Map
   val listInput = List("abc", "abc", "bc", "b", "abc")
   
   def generateMap(elem: List[String],mapList:Map[String, Int]):Map[String,Int] = elem match {
     case x :: y => if (mapList.keySet.contains(x)) 
       generateMap(y, mapList ++ Map(x-> (mapList(x)+1)))
       else generateMap(y, mapList ++ Map(x-> 1))
     case Nil => mapList
   }
   
   //val outputMap = generateMap(listInput, Map.empty)
   //println(outputMap)      //Map(abc -> 3, bc -> 1, b -> 1)
   
   //for comprehension returning data structure
   def pythagronTriangle(n:Int) = for {
     x <- 1 to n
     y <- x to n 
     z <- y to n
     if (x * x + y * y ==  z * z)
   } yield (x,y, z)
   
   //for comprehension breakdown
   def pythagronTriangle2(n:Int) = (1 to n) flatMap ( x => 
     (x to n) flatMap(y=>  
       (y to n) filter (z => x *x + y*y == z*z) map(z => (x, y, z))))
   
   //val pythagronOutput = pythagronTriangle2(21)
   //println(pythagronOutput)
   
   //aggregate function will use combiner for final computation and run process in parallel
   val tsc = Tuple2(0,0) //create initial tuple (both sum and count are zero)
   val shortList = List.tabulate(5)(n=>n*n) //create list
   
   val aggOuput = shortList.aggregate(tsc) ((tsc,elem) => (tsc._1+elem, tsc._2+1), (tsc1, tsc2) => (tsc1._1+tsc2._1, tsc2._2+tsc2._2))
   //println(aggOuput)
   
   //andThen is partial function which produces output based on input parameter
   //no computation processing needed when compared to map which would rather created new list
   val l = List (1,2,3,4)
   val listAndThenExample = l.andThen(_*2)
   val liftexample = listAndThenExample.lift    // converts partial function to complete function and returns Option as data type
   //println(listAndThenExample(4))    //returns exception when indexOutofBound
   println(liftexample(4))   //returns None
   
   def defaultReturn(x:Int) =  println("Wrong argument "+ x)
   
   //applyOrElse gets integer as input and returns default function in case of value not found
   val listApplyOrElse = l.applyOrElse(_:Int,defaultReturn(_))    
   
   println(listApplyOrElse(5))
       
    //println(maxMinListElement)  //prints (8,0)
    //println(valAndCountList7)    //prints (5,20)
    //println(countList7)    //prints 5      
    //println(stringList)    //prints "hello"    
    //println(list8)      //accumulator starts from 410 and moves right to left
    //println(list7)    //accumulator starts from 0 and adds element one by one
    //println(list6)      //List(0, 0, 0, 0, 0, 0, 6)
    //println(list5)    //same as :: List(3, 0, 0, 0, 0, 0, 0)
    //println(list4)    //same as ::: List(0, 0, 0, 0, 0, 0, 0, 2, 4, 6, 8)
    //println(list3.init) //List(0, 2, 4, 6)
    //println(list3.head) // 0
    //println(list3.tail) //List(2, 4, 6, 8)
  }
}