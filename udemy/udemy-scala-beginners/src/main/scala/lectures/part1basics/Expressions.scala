package lectures.part1basics

object Expressions extends App {
  var x = 1 + 2  // Expression
  println(x)

  println(2 + 3 * 4)
  // mathematical expressions: + - * /
  // bitwise expressions & | ^ << >> >>>

  println(x == 1)
  // Comparisons: == != > >= < <=

  println(!(x == 1))
  // Operators: ! && ||

  // Everything in Scala is a Expression:
  val aWeirdValue = (x = 3)  // Unit === void
  println(s"aWeirdValue: $aWeirdValue")

  // Instructions (executed / Do Something) vs Expressions (evaluated / Value)

  // Instruction
  var result1: String = ""
  if x == 2 then {
    result1 = "two"
  } else {
    result1 = "i don't know"
  }

  // Expression
  var result2: String = if(x == 2) "two" else "i don't know"

  println(s"result 1: $result1")
  println(s"result 2: $result2")
}
