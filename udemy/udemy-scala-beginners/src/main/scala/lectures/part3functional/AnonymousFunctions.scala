package lectures.part3functional


object AnonymousFunctions extends App {

  // Anonymous function (LAMBDA)
  val doubler1 = (i: Int) => i * 2
  println(doubler1(2))

  // Equivalent Syntax
  val doubler2: Int => Int = (i) => i * 2
  println(doubler2(2))

  // No way to infer the parameter types (INVALID)
  // val doubler3 = (i) => i * 2

  // Multiple arguments needs parentheses
  val adder: (Int, Int) => Int = (a, b) => a + b

  // No parameters
  val justDoSomething: () => Int = () => 42

  // CAUTION: Lambdas need to be called with the parentheses (different from methods)
  println(justDoSomething)    // function instance representation (AnonymousFunctions$$$Lambda$...)
  println(justDoSomething())  // 42

  // Curly brances with Lambdas
  val stringToInt = { (s: String) =>
    s.toInt
  }

  // Going crazy on (syntatic) sugar
  val niceIncrementer: Int => Int = _ + 1  // "_ + 1" is equivalent to x => x + 1
  val niceAdder : (Int, Int) => Int = _ + _  // "_ + _" is equivalent to (a, b) => a + b

  println(niceIncrementer(1))
  println(niceAdder(1, 2))
}
