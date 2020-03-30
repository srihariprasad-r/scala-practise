package oodetails

object introToLists {
  def main(args:Array[String]):Unit = {
    
    /* list basics */
    
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
    
    /**commented off this as it creates side effects
    
    sampleString match {
      case h :: t => println(h)
      case _ => println("catch all")
    } 
    
    **/
    
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
   //println(liftexample(4))   //returns None
   
   def defaultReturn(x:Int) =  println("found its wrong argument "+ x)
   
   def normalReturn(x:Int) =  println("argument present "+ x)   
   
   //partial Function
   val listBound:PartialFunction[Int,Int] =  {
     case x if x >= 0 && x < l.length/2 => x
   }
   
   val listBound2:PartialFunction[Int,Int] =  {
     case x if x >= l.length/2 && x < l.length => x
   }
   
   //applyOrElse gets integer as input and returns default function in case of value not found
   val listApplyOrElse = l.applyOrElse(_:Int,defaultReturn _ )    
   
   //println(listApplyOrElse(5))    //prints "Wrong argument 5"
   
   //above scenario with applyOrElse is converted to partial function with andThen
   val listAndThen = l andThen normalReturn _
   //println(listAndThen(2))

   //above scenario with applyOrElse is converted to partial function with andThen
   val listComposeAndThen =  listBound andThen l
   val listCompose =  normalReturn _ compose listComposeAndThen
   val listFailOver = listComposeAndThen applyOrElse(_:Int, defaultReturn _) 
   //println(listComposeAndThen.isDefinedAt(2))    //prints "true"
   //println(listCompose(2))    //prints "argument present 3"
   //println(listFailOver(5))    //prints "found its wrong argument 5"
   //println(listComposeAndThen(2))  //prints 3
   
   //println(listBound.isDefinedAt(3))  //prints "true"
   
   //chaining partial functions
   val partial = listBound orElse listBound2
   //println(partial(3))

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
   
   /**********************************************************************************************/
   /* case class and list operations */
   
   //case class to create address constructor
   case class Address ( city: String, State: String)
   
   //case class to create Place of stay constructor   
   case class placeOfStay (name: String, homeaddress: Address , orgaddress: organization)

   //added new constructor to avoid code break
   case class employeeStay (name: String, homeaddress: Address)   
   
   //case class to create organization constructor
   case class organization (name: String, address: Address)
   
   val pOS1 = List(employeeStay("P1", Address("MS","TN")),
                   employeeStay("P2", Address("HD","TG")),
                   employeeStay("P3", Address("TC","TN")),
                   employeeStay("P4", Address("TD","TN")),  
                   employeeStay("P5", Address("HD","TG")))
                   
   val pOS2 = List(placeOfStay("P1", Address("MS","TN"), organization("FP Pvt Ltd", Address("HH", "TN"))),
                   placeOfStay("P2", Address("HD","FL"), organization("KP Pvt Ltd", Address("PO", "DC"))),
                   placeOfStay("P3", Address("TC","TN"), organization("GT Pvt Ltd", Address("NY", "FL"))),
                   placeOfStay("P4", Address("TD","TN"), organization("FP Pvt Ltd", Address("HH", "NY"))),  
                   placeOfStay("P5", Address("HD","DC"), organization("MK Pvt Ltd", Address("HH", "OL"))))
   
   //Below gets list(name, state)
   val stateCount = pOS1.map { case employeeStay(name, address) => (name,address.State)} 
   
   //groups based on state-> for every item value, extracts the name(which is field 1) and creates swap 
   val getCount = stateCount groupBy(_._2) mapValues(_.map(_._1)) map { case (k,v) => (v,k)} 
   
   //println(getCount)      //prints Map(List(P1, P3, P4) -> TN, List(P2, P5) -> TG)    

   //Below gets list(name, state)
   val pOS = pOS2 map {case placeOfStay(name, address, org)  => name-> (address.State, org.address.State, org.name)} 
   
   //groups based on state-> for every item value, extracts the name(which is field 1) and creates swap 
   val getPOS = pOS map {case (k,v) => (v._1 , k,v._2)} groupBy(_._3) mapValues(_.map{case (v1, v2, v3) => Map(v2-> v3)})
   
   //println(getPOS)  //Map(TN -> List(P1, P3, P4), DC -> List(P5), FL -> List(P2))
   
   //This function will return rows which have same home and organization location
   val filterPoS = pOS filter { case (k, v) => v._1 == v._2} groupBy(_._1) mapValues(_.map(_._2._3)) 
   //println(filterPoS)      //prints Map(P1 -> List(FP Pvt Ltd))
   
   val diffWorkLocations = pOS2 map {c => (c.homeaddress.State,c.orgaddress.address.city)} groupBy(_._2) mapValues(_.map(_._1))   
   
   //println(diffWorkLocations)  //prints Map(PO -> List(FL), HH -> List(TN, TN, DC), NY -> List(TN))
   
   /**********************************************************************************************/
   
   /* flatMap example on nested list */
   
   //println(List(2) ::: List(1))
   
   val flattenList = List(List(1,2), List(3,4))
   
   //flatten works only when there is traversable elements such as List and will not work for non-traversable
   //elements such as Int
   //println(flattenList.flatten)  //prints List(1, 2, 3, 4)
   
   //This works as well
   //println(flattenList.flatMap(identity))  //print List(1, 2, 3, 4)
   
   val nestedlist = List(List(4, List(5,6)), 5) //List(List(1, 2, 3, 4, List(5, 6, List(7, 8))))
   
   //println(nestedlist.flatMap(identity))
   
   //This function would flatten the nested list with recursion
   def flattenListf1(l:List[Any]):List[Any] = l match {
     case Nil => Nil 
     case (h:List[Int]) :: tail => flattenListf1(h) ::: flattenListf1(tail)
     case head :: tail => head :: flattenListf1(tail)     
   }
   
   val flattenedList = flattenListf1(nestedlist)
   //println(flattenedList)  //prints List(4, 5, 6, 5)
   
   //this uses flatMap
   def flatMapListf1(l:List[Any]):List[Any] = l flatMap { 
     case (h:List[_]) => flatMapListf1(h)
     case head => List(head)     
   }   
   
   val flatMapList = flatMapListf1(nestedlist)
   //println(flatMapList)  //prints List(4, 5, 6, 5)   

    val listInput1 = List(1):::List(List(2))
    
    val flatList = listInput1.flatMap(c => c match {                           
                          case i:Int => List(i)     
                          case x: List[_] => x
                         })
                         
    val list = List(List(1,2),List(3),List(4),5)
    
    //This function would flatten the nested list without recursion using fold function
    val flattenFirst :List[Int]  = list flatMap {
      case i: Int => List(i)
      case x:List[Int] => x
    }
    
   //created partial function
    val foldedNext = flattenFirst.foldLeft(0) _ 
    
    val output:Int  = foldedNext((acc, elem) => acc + elem) 
    //println(output)   //prints 15

    /**********************************************************************************************/
   /* fold function examples */
    
    val sampleList = List(1,2,3,4,5,6)
    
    def product(list:List[Int]) = list.foldLeft(1)((acc,elem)=> acc*elem)
    //println(product(sampleList))  //prints 720
    
    //finding average using foldleft 
    def average(list:List[Int]):Double = (0.0 /: list)((acc,elem) => acc+elem)/(0.0 /:list)((acc,_) => acc+ 1)    
    //println(average(sampleList)) //prints 3.5
    
    def lastItem(list:List[Int]):Int = (0 /: list)((_,elem) => elem)    
    //println(lastItem(sampleList)) //prints 6

    //finding last but one element with recursion
    def lastButOneItem(list:List[Int]):Int = list match {
      case List(i) => i
      case List(i, _) => i
      case h :: t => lastButOneItem(t)
      case Nil => 0
    }
    //println(lastButOneItem(sampleList)) //prints 5    
    
    //finding last but one element with foldleft function     
    def lastButOneFold(list:List[Int]):(Int,Int) = list.foldLeft((list.head, list.tail.head))((r,c) => (r._2, c))  
    //println(lastButOneFold(sampleList))
    
    //find if element exists in list
    def findItemList(list: List[Int], item: Int): Boolean = list.foldLeft(false)((acc,elem) => acc || elem == item)
    //println(findItemList(sampleList,3))

    //find if element and return the index of that element in list provided
    def findItemIndex(list: List[Int], item: Int): Int = list.tail.foldLeft((list.head,0)) {
              (acc,elem) => if (acc._1 == item) acc  else (elem,acc._2+1) } match {
                case (value, idx) if (value == item) => idx
                case _ => throw new Exception ("No value found")
              }
    println(findItemIndex(sampleList,3))    //prints 2
  }
}