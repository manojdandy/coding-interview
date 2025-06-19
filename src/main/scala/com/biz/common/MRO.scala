package com.biz.common

trait A { def greet() = println("A") }
trait B extends A { override def greet() = println("B") }
trait C extends A { override def greet() = println("C") }

class D extends B with C


object MRO {
  def main(args: Array[String]): Unit = {
    val d = new D()
    d.greet()

  }
}
