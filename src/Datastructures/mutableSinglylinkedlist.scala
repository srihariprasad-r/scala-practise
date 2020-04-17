package Datastructures

class mutableSinglylinkedlist[A] {
  
  //Node class takes var as arguments as they can have methods which are mutable
  private class Node(var data: A, var next: Node)
  
  //define head of linked list which is sentinel node with NULL value
  private var head: Node = null
  
  //apply method is a companion object which would move the pointer to needed location
  def apply(index: Int): A  = {
    require(index >= 0 )
    //initial position of cursor is set to head
    var cursor = head
    for (i <- 0 until index) cursor = cursor.next 
    cursor.data
  }
  
  def update(index: Int, data: A) {
    require(index >= 0 )
    //initial position of cursor is set to head
    var cursor = head
    for (i <- 0 until index) cursor = cursor.next
    cursor.data = data    
  }
  
  def insert(index: Int, data: A) = {
    require(index >= 0 )
    if (index == 0) {
      head = new Node(data, head)
    } else {
    //initial position of cursor is set to head
    var cursor = head
    for (i <- 0 until index-1) cursor = cursor.next
    cursor.next = new Node(data, cursor.next)
  }
  }
   
  def remove (index: Int): A = {
    require(index >= 0 )
    if (index == 0) {
      var ret = head.data
      head = head.next
      ret
    } else {
    //initial position of cursor is set to head
    var cursor = head
    for (i <- 0 until index-1) cursor = cursor.next
    val ret = cursor.next.data
    cursor.next = cursor.next.next
    ret
  }
  }
  
}

object mutableSinglylinkedlist{
  def main(args: Array[String]): Unit = {
    var l1 : mutableSinglylinkedlist[Int] = null
    
    l1 = new mutableSinglylinkedlist[Int]()
    
    l1.insert(0, 10)
    l1.insert(1, 11)
    l1.insert(2, 12)
    l1.insert(3,13)
    
    println(l1(2))
  }
}