package Datastructures

import scala.reflect.ClassTag

class ArrayQueue[A: ClassTag] {

  private var data = new Array[A](10)
  private var popindex = 0       //this index will track front index item in queue which points to the element should be popped (FIFO)
  private var pushindex = 0      //this index will track index of queue where new element should be pushed
  
  def enqueue(a: A): Unit = {
    //below condition checks when to create a copy when all index position are full and need to expand
    if ((pushindex + 1) % data.length == popindex) {
      val tmp = new Array[A](data.length * 2)
      //copy happens based on modulo. example: (2+0) % 6 == 2 , so new array(0) <- old array(2)
      for (i <- 0 until data.length - 1) tmp(i) = data((popindex +i) % data.length)
      data = tmp
      //after copy reset the index to be popped to begining of array
      popindex = 0
      pushindex = data.length - 1
    }
    data(pushindex)
    pushindex = (pushindex + 1) % data.length
  }
  
  def dequeue(): A = {
    val ret = data(popindex)
    popindex = (popindex + 1) % data.length
    ret
  }
  
  //peek will fetch the element which would be popped
  def peek(): A = data(popindex)
  
  def isEmpty: Boolean = popindex == pushindex      
  
  
}