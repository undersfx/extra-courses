package lectures.part1basics

object ValuesVariablesTypes extends App {
  // Values
  val x: Int = 42  // define a value
  println(x)
  // y = 2  // This will give Error because "vals" are immutable

  val y = 42  // type inference

  val sString: String = "Hello Scala" // NOTE: semicolons ";" are not necessary
  val aBoolean: Boolean = true  // or false
  val aChar: Char = 'a'
  val anInt: Int = -2147483648  // 4B (32 bits) signed (from -2147483648 to 2147483647)
  val aShort: Short = -32768    // 2B (16 bits) signed (from -32768 to 32767)
  val aLong: Long = -9223372036854775808L  // 8B (64 bits) signed (from −9223372036854775808 to 9223372036854775807)
  val aFloat: Float = 2.0f
  val aDouble: Double = 3.14

  // Variables
  var aVariable: Int = 4
  aVariable = 5  // This will _not_ give Error because "vars" are mutable
  aVariable += 1
  println(aVariable)
}