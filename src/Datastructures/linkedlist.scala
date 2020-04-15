package Datastructures

class linkedlist[A] {
  
  //Node class takes var as arguments as they can have methods which are mutable
  private class Node(var data: A, var next: Node)
  
  //define head of linked list which is senitel with NULL value
  private var head: Node = null
  
  //apply method is a companion object which would move the pointer to needed loction
  def apply(index: Int): A  = {
    //initial position of cursor is set to head
    var cursor = head
    for (i <- 0 until index) cursor = cursor.next
    cursor.data
  }
  
}