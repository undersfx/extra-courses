package lectures.part3functional

import exercises.MyList

object WhatsAFunction extends App {
  // Dream: use functions as first class elements
  // Problem: JVM uses OOP for everything

  // Scala workaround example
  trait MyFunction[A, B] {
    def apply(element: A): B
  }

  val doubler = new MyFunction[Int, Int] {
    override def apply(element: Int): Int = element * 2
  }
  println(doubler(2))

  // Scala default implementations (Function0...22)
  val stringtoIntConverter = new Function1[String, Int] {
    override def apply(s: String): Int = s.toInt
  }
  println(stringtoIntConverter("3") + 4)

  // Syntactic Sugar for the above construction
  val adder: Function2[Int, Int, Int] = new Function2[Int, Int, Int] {
    override def apply(n: Int, m: Int): Int = n + m
  }
  println(adder(1, 2))

  // Function Types: Function2[A, B, R] === (A, B) => R
  val adder2: ((Int, Int) => Int) = new Function2[Int, Int, Int] {
    override def apply(n: Int, m: Int): Int = n + m
  }
  println(adder2(1, 2))

  // Same as
  val adder3: ((Int, Int) => Int) = (n: Int, m: Int) => n + m
  println(adder3(1, 2))

  // Same as
  val adder4: ((Int, Int) => Int) = _ + _
  println(adder4(1, 2))

  // REMINDER: ALL SCALA FUNCTIONS ARE INSTANCES OF CLASSES


  /*
    1. Define a function which takes 2 string and concatenates them
  */
  def concat: (String, String) => String = (s1: String, s2: String) => s1 + s2
  println(concat("hello", " world!"))

  /*
    2. Define a function which takes a Int and return another function which takes a Int and returns a Int
      - What's the type of this function
      - How to do it
  */
  def foo: (Int) => (Int) => Int = (i: Int) => (j: Int) => i + j

  val foo2 = foo(2)
  println(foo2(1))

  // OR
  println(foo(1)(2))  // Currried function

  /*
    3. Transform the MyPredicate and MyTransformer into function types
  */
  // high-order functions will do it:
  //  def map[B](transformer: A => B): MyList[B]
  //  def flatMap[B](transformer: A => MyList[B]): MyList[B]
  //  def filter(predicate: A => Boolean): MyList[A]
}
