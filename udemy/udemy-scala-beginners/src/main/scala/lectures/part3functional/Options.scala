package lectures.part3functional

import scala.util.Random

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

  /*
  * Exercises
  */

  // fetch from elsewhere
  val config: Map[String, String] = Map(
    "host" -> "10.1.1.1",
    "port" -> "80"
  )

  // Connection API
  class Connection {
    def connect = "Connected"
  }

  object Connection {
    private def random = new Random(System.nanoTime())

    def apply(host: String, port: String): Option[Connection] =
      if (random.nextBoolean()) Some(new Connection)
      else None
  }

  // Establish Connection, is so, print the connect method
  val host: Option[String] = config.get("host")
  val port: Option[String] = config.get("port")
  println(s"Got config host: ${host.getOrElse("Nothing")} and port: ${port.getOrElse("Nothing")})")

  val conn: Option[Connection] =
    (host, port) match {
      case (Some(host), Some(port)) =>
        println(s"Host are valid (Connection(host=${host}, port=${port}).")
        Connection(host, port)
      case (_, _) => None
    }

  println("Trying to connect.")
  conn match {
    case Some(c) => println(c.connect)
    case None => println("Connection Failed")
  }

  // for-comprehensions
  val connectionStatus = for {
    host <- config.get("host")
    port <- config.get("port")
    connection <- Connection(host, port)
  } yield connection.connect
  connectionStatus.foreach(println)
}
