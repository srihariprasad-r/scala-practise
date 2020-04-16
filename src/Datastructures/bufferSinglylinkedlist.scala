package Datastructures

import collection.mutable

//left as abstract as 6 methods yet to be implemented from Buffer class
abstract class bufferSinglylinkedlist[A] extends mutable.Buffer[A]{
  
  private class Node(var data: A, var next: Node)
  
  private var fst: Node = null
  private var lst: Node = null
  private var count: Int = 0
  
  def length: Int = count
  
  def clear(): Unit = {
    var fst = null
    var lst = null
    var count = 0
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
  
  
  }
  