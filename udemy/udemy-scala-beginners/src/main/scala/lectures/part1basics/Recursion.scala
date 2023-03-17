package lectures.part1basics

import scala.annotation.tailrec

object Recursion extends App {
  // stack recursive factorial
  def factorial(n: Int): Int =
    if (n <= 1) 1
    else n * factorial(n - 1)

  // tail recursive factorial
  def tail_factorial(n: Int): BigInt =
    @tailrec  // annotation tells the compiler to raise an error in case this function is not tail recursive
    def helper(n: Int, accumulator: BigInt): BigInt =
      if (n <= 1) accumulator
      else helper(n - 1, n * accumulator)

    helper(n, 1)

//  println(factorial(5000)) // Exception in thread "main" java.lang.StackOverflowError
//  println(tail_factorial(5000))

  /*
    WHEN IN NEED OF LOOPS, USE _TAIL_ RECURSION.

    TAIL RECURSION =
      Use recursive call as the complete last expression
      not as part of a expression that need evaluation
      "n * factorial(n - 1)" vs "helper(n - 1, n * accumulator)"
  */

  def repeat(s: String, n: Int): String =
    @tailrec
    def helper(s: String, n: Int, acc: String): String =
      if (n == 0) acc
      else helper(s, n - 1, s + acc)

    helper(s, n, "")

  println(repeat("Hello! ", 3))


  def isPrime(n: Int): Boolean = {
    @tailrec
    def helper(i: Int, still: Boolean): Boolean = {
      if (!still) false
      else if (i <= 1) true
      else helper(i - 1, n % i != 0 && still)
    }

    helper(n / 2, true)
  }

  println(isPrime(7))
  println(isPrime(8))


  def fibonacci(n: Int): Int = {
    @tailrec
    def helper(n: Int, previous: Int, last: Int): Int =
      if (n <= 1) previous
      else helper(n - 1, last, previous + last)

    helper(n, 1, 1)
  }

  println(fibonacci(1))
  println(fibonacci(2))
  println(fibonacci(3))
  println(fibonacci(4))
  println(fibonacci(5))
  println(fibonacci(6))
}

