package lectures.part3functional

object Options extends App {
  val myFistOption: Option[Int] = Some(5)
  println(myFistOption)

  val noOption: Option[Int] = None
  println(noOption)

  // Unsage API's
  def unsafeMethod(): String = null

  val unsafeResult = Option(unsafeMethod()) // Some or None
  println(unsafeResult.getOrElse("hello"))

  // Chained methods
  def safeMethod(): String = "Valid string"

  val chaniedResult = Option(unsafeMethod()).orElse(Option(safeMethod()))

  println(chaniedResult.getOrElse("No Option"))

  // Designing better unsafe API's
  def betterUnsafeMethod(): Option[String] = None

  def betterSafeMethod(): Option[String] = Some("Valid string")

  val betterChainedResult1 = betterUnsafeMethod() orElse betterSafeMethod()
  val betterChainedResult2 = betterUnsafeMethod() orElse betterUnsafeMethod() getOrElse "No Option"

  println(betterChainedResult1)
  println(betterChainedResult2)

  val myNullOption: Option[Int] = None

  // Option API
  println("get:           " + myFistOption.get) // DO NOT USE, UNSAFE!!! Nulls will raise exception (e.g. myNullOption.get)
  println("getOrElse:     " + myFistOption.getOrElse(6))
  println("getOrElse:     " + myNullOption.getOrElse(6)) // Safe Access
  println("isEmpty:       " + myFistOption.isEmpty) // Useful test for validations
  println("map:           " + myFistOption.map(_ * 2))
  println("flatMap:       " + myFistOption.flatMap(x => Option(x * 10)))
  println("filter(true):  " + myFistOption.filter(_ < 10))
  println("filter(false): " + myFistOption.filter(_ > 10)) // :O  -> Turns Some(5) into None (5 is not > 10)


}
