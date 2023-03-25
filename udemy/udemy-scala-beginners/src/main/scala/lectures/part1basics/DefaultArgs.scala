package lectures.part1basics

object DefaultArgs extends App {
  def tailFactorial(n: Int, acc: Int = 1): Int = {
    if (n <= 1) acc
    else tailFactorial(n - 1, n * acc)
  }

  val fact10 = tailFactorial(10)

  def greeting(name: String, age: Int, greet: String = "Hello"): Unit = {
    println(s"$greet, my name is $name and I'am $age years old.")
  }

  greeting("Emily", 87)  // params passed as positional arguments
  greeting(greet = "Howdy", age = 74, name = "Thiago") // params passed as named arguments (do not need to be ordered)
}
