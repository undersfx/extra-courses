package lectures.part1basics

object CallByValueOrByName extends App {
  def calledByValue(x: Long): Unit = {  // expresion x is evaluated before the call
    println("by value call: " + x)
    println("by value call: " + x)
  }

  def calledByName(x: => Long): Unit = {  // expression x is evaluated only when needed
    println("by name call: " + x)
    println("by name call: " + x)
  }

  calledByValue(System.nanoTime())
  calledByName(System.nanoTime())

  // eager vs lazy evaluation example
  def infinite(): Int = 1 + infinite()
  def printFirst(eagerArg: Int, lazyArg: => Int) = println(eagerArg)

  printFirst(eagerArg = 42, lazyArg = infinite())   // 42
  printFirst(eagerArg = infinite(), lazyArg = 42)   // java.lang.StackOverflowError
}
