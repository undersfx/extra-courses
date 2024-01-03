package lectures.part2oop

object Exceptions extends App {

  val x: String = null
//  println(x.length)  // ERROR: java.lang.NullPointerException

  // 1. Throwing a exception
  // throwable classes extend the Throwable class (Exception and Error are the major Throable subtypes)
//  val aWeirdValue: String = throw new NullPointerException  // ERROR: java.lang.NullPointerException

  // 2. how to catch exceptions
  def potentialFailure(fail: Boolean): Int =
    if (fail) throw new RuntimeException("sorry")
    else 42

  val potentialFail: AnyVal = // AnyVal because if RuntimeException is triggered, the return will be of type Unit
    try {
      potentialFailure(fail = true)
    } catch {
      case e: RuntimeException => println("RuntimeException catched...")
    } finally {
      // optional
      // code that will get executed no mater what
      // does not influence the return type
      // use for side effects (e.g. logging)
      println("Ending.")
    }

  println(potentialFail)

  // 3. create your own exceptions
  class MyException extends Exception
  val exception = new MyException

  throw exception
}
