package Datastructures

import scala.reflect.ClassTag

class ArrayStack[A: ClassTag] {
  
  private var data = new Array[A](10)
  private var index = 0
  
  def push(a: A) : Unit = ???
  
  def pop(): A = {
    index -= 1
    data(index)
  }
  
  //peek fetches element which is last but one insetad of removing, similar to pop, but doesn't remove the element
  def peek: A = data(index -1)
  
  def isEmpty: Boolean = index == 0
  
}