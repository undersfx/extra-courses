package lectures.part3functional

object HOFsAndCurries extends App {
  // higher order functions
  // Take a function as parameters or return a function as results
  // (map, flatMap, filter, ...)

  // Function that applied a function a number N of times over value X
  // nTimes(f, 3, 10) === f(f(f(10)))

  def nTimes(f: Int => Int, n: Int, x: Int): Int = {
    if (n <= 0) x
    else nTimes(f, n - 1, f(x))
  }
  val plusOne: Int => Int = _ + 1
  println(nTimes(plusOne, 3, 10))

  // Same behavior but returning a preped function to use in any val
  def nTimesBetter(f: Int => Int, n: Int): Int => Int = {
    if (n <= 0) (x: Int) => x
    else (x: Int) => nTimesBetter(f, n - 1)(f(x))
  }
  val add3 = nTimesBetter(plusOne, 3)
  println(add3(10))


  // Curried Functions
  val superAdder: Int => (Int => Int) = (x: Int) => (y: Int) => x + y
  val add10 = superAdder(10)
  println(add10(7))
  println(superAdder(10)(7))

  // Multiple parameters lists
  def curriedFormatter(f: String)(x: Double): String = f.format(x)

  val standardFormat: Double => String = curriedFormatter("%4.2f")
  val precisedFormat: Double => String = curriedFormatter("%10.8f")

  println(standardFormat(Math.PI))
  println(precisedFormat(Math.PI))
}
