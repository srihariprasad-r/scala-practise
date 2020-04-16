package Datastructures

import collection.mutable

//left as abstract as 6 methods yet to be implemented from Buffer class
abstract class bufferSinglylinkedlist[A] extends mutable.Buffer[A]{
  
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
  
  
  def upd(index: Int, data: A): A = {
    require(index >=0 && index < count)
    var cursor = fst
    for (i <- 0 until index) cursor = cursor.next
    cursor.data = data
    cursor.data
  }
  
  //remove method    
  def remove(index: Int) : A = {
    require(index >= 0 && index < count)
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
  
  }
  