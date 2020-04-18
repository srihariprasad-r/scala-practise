package Datastructures

import scala.reflect.ClassTag

class ArrayQueue[A: ClassTag] {

  private var data = new Array[A](10)
  private var popindex = 0 
  private var pushindex = 0
  
  def enqueue(a: A): Unit = {
    if ((pushindex + 1) % data.length == popindex) {
      val tmp = new Array[A](data.length * 2)
      for (i <- 0 until data.length - 1) tmp(i) = data((popindex +1) % data.length)
      data = tmp
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
  
  def peek(): A = data(popindex)
  
  def isEmpty: Boolean = popindex == pushindex      
  
  
}