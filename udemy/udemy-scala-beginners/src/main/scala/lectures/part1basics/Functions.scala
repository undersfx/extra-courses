package lectures.part1basics

import scala.annotation.tailrec

object Functions extends App {
  private def greeter(name: String, age: Int): String = {
    s"Hi, my name is $name and I am $age years old."
  }

  println(greeter("Thiago", 30))

  private def factorial(n: Int): Int = {
    if (n <= 0) 1
    else n * factorial(n - 1)
  }

  println(factorial(1))
  println(factorial(2))
  println(factorial(3))
  println(factorial(4))


  private def fibonacci(n: Int): Int = {
    if (n <= 2) 1
    else fibonacci(n - 1) + fibonacci(n - 2)
  }

  println(fibonacci(1))
  println(fibonacci(2))
  println(fibonacci(3))
  println(fibonacci(4))
  println(fibonacci(5))
  println(fibonacci(6))

  private def isPrime(n: Int): Boolean = {
    def prime(n: Int, i: Int): Boolean = {
      if (i == 1) true
      else (n % i != 0) && prime(n, i - 1)
    }
    prime(n, n / 2)
  }

  println(isPrime(10))
  println(isPrime(5))
  println(isPrime(4))
  println(isPrime(3))
  println(isPrime(2))
}
