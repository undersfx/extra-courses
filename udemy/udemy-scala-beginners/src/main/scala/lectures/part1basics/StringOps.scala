package lectures.part1basics

object StringOps extends App {
  val str: String = "Hello, I am learning Scala"

  // Java String Class specific
  println(str.charAt(2))
  println(str.substring(7, 11))
  println(str.split(" ").toList)
  println(str.startsWith("Hello"))
  println(str.startsWith("Hi"))
  println(str.replace(" ", "-"))
  println(str.toLowerCase())
  println(str.length)

  val aNumberString = "42"
  val aNumber = aNumberString.toInt

  // Scala specific
  println('a' +: aNumberString)
  println(aNumberString :+ 'z')
  println(str.reverse)
  println(str.take(2))


  // Scala-specific Interpolators
  val name = "Thiago"
  val age = 42

  // S-Interpolators
  println("Hello, my name is $name and I am $age years old.")
  println(s"Hello, my name is $name and I am $age years old.")
  println(s"Hello, my name is $name and I will be turning ${age + 1} years old tomorrow.")

  // F-Interpolators
  val speed = 1.2f
  println(f"$name can run at $speed meters per minute.")
  //  println(f"$name%3d can run at $speed%2.2f meters per minute.")  // Checks for type correcness

  // Raw-Interpolators
  val escaped = "This is a \n newline"

  println(raw"This is a \n newline")
  println(raw"$escaped")  // interpolating not raw string does not work
}