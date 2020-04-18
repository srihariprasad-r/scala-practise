package Datastructures

import collection.mutable

//left as abstract as 6 methods yet to be implemented from Buffer class
class bufferSinglylinkedlist[A] extends mutable.Buffer[A]{
  
  private class Node(var data: A, var next: Node)
  
  private var fst: Node = null
  private var lst: Node = null        //added lst node as tail node to help in reducing the O(n) traversal
  private var count: Int = 0          //added this count to perform O(1) for call on length
  
  def length: Int = count
  
  def clear(): Unit = {
    var fst = null
    var lst = null
    var count = 0
  }
  
  //below method will prepend elements to existing linked list
  def +=:(elem: A) = {
    fst = new Node(elem, fst)
    if (lst == null) lst = fst        //this check is performed if linked list is empty and if so, head and tail will point to same node
    count += 1                       // increment count by 1 after prepend
    this
  }
  
  //below method will append elements to existing linked list
  def +=(elem: A) = {
    if (lst == null) {              //check if list is empty, if so, add new node and have head and tail point to same node
      fst = new Node(elem, null)
      lst = fst
    } else {
      lst.next = new Node(elem, null)      //create a new node which is last element
      lst = lst.next                       //move the tail to new node created above
    }
    count += 1                            //increment count by 1 after append
    this
  }
  
  
  def apply(index: Int): A = {
    require(index >= 0 && index < count)
    var cursor = fst
    for (i <- 0 until index)
      cursor = cursor.next
      cursor.data
    }
  
  
  override def update(index: Int, data: A): Unit = {
    require(index >=0 && index < count)
    var cursor = fst
    for (i <- 0 until index) cursor = cursor.next
    cursor.data = data
    //cursor.data
  }
  
  //remove method    
  def remove(index: Int) : A = {
    require(index >= 0 && index < count)
    count -= 1              //decrement count by 1 as it is removal of elements
    if (index == 0){          //removes index at 0
      val ret = fst.data
      fst = fst.next
      if (fst == null) lst = fst      //if there is only one element removed, tail and head reset to null
      ret
    } else {
      var cursor = fst
      for (i <- 1 until index) cursor = cursor.next
      val ret = cursor.data
      cursor.next = cursor.next.next
      if (cursor.next == null) lst = cursor        //if last element is removed, tail is shifted to last but one node
      ret
    }
  }
  
  //add many elements to existing linked list
  def insertAll(index: Int, elem: collection.Traversable[A]): Unit = {
    require(index >= 0 && index < count +1)
    //below create new linked list with all elements and attaches to existing linked list
    if (elem.nonEmpty) {    
      val headnewElement = new Node(elem.head, null)      //form with head of iterable as point it as first element
      var lastnewElement = headnewElement                  //last node will point to head as there is only one element
      count += 1
      for (e <- elem.tail) {
        lastnewElement.next = new Node(e, null)      //form other nodes based on iteration
        lastnewElement = lastnewElement.next        //move the pointer
        count += 1
      }
      if ( index == 0){
        lastnewElement.next = fst          //move last element and point to null as there are no other elements
        fst = headnewElement
        if (lst == null) lst = lastnewElement
      } else {
        var cursor = fst
        for (i <- 1 until index) cursor = cursor.next
        lastnewElement.next = cursor.next                //attach last node of newly formed linked list as current node's next 
        cursor.next = headnewElement                     //current node's next will be head of newly formed linked list
        if (lastnewElement.next == null) lst = lastnewElement
      }
    }
  }
  
  def iterator: Iterator[A] = new Iterator[A]{
    var cursor = fst
    def hasNext: Boolean = cursor != null      //returns True until cursor has next node
    def next(): A = {
      var ret = cursor.data
      cursor = cursor.next
      ret
    }
  }
  
  }

object bufferSinglylinkedlist {
  def main(args: Array[String]): Unit = {
    val b1 = new bufferSinglylinkedlist[Int]()
    
    b1.insert(0, 10)
    b1.insert(1,11)
    b1.insert(2, 12)
    b1.insert(3,13)
    
    val l1 = List(2,3,4)      //created collection for inserting to existing node
    val b2 = b1.insertAll(3, l1)      //insert at node 3
    println(b1(2))
  }
}
  