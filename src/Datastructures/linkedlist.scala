package Datastructures

class linkedlist[A] {
  
  //Node class takes var as arguments as they can have methods which are mutable
  private class Node(var data: A, var next: Node)
  
  //define head of linked list which is senitel with NULL value
  private var head: Node = null
  
  //apply method is a companion object which would move the pointer to needed loction
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
  
  def insert(index: Int, data: A) {
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
  
}