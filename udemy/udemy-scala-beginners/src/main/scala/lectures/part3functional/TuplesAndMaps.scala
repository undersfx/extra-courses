package lectures.part3functional

import scala.annotation.tailrec

object TuplesAndMaps extends App {
  // Tuples - finite ordered "lists"

  val aTuple       = new Tuple2(2, "Foo")
  val otherTuple   = Tuple2(2, "Foo")
  val anotherTuple = (2, "Foo")
  // (Int, String) is syntactic sugar for Tuple2[Int, String]
  // Limited to 22 element types: Tuple1 to Tuple22 (same limit in Function types)

  // Tuple operations
  println(aTuple)
  println(aTuple._1)
  println(aTuple._2)
  println(aTuple.swap)
  println(aTuple.copy(_2 = "Bar"))

  // Maps - associate keys to value (k:v pair)
  val phoneBook = Map(
    ("Daniel", 123),
    ("Jim", 555),
  )
  println(phoneBook)

  val styledPhoneBook = Map(
    "Daniel" -> 123,
    "Jim" -> 555,
  )
  println(styledPhoneBook)

  // Map operations
  println(styledPhoneBook("Jim")) // apply method returns the value
  println(styledPhoneBook.contains("Jim"))

  // add a new pair
  val newPairing = "Rose" -> 111
  println(styledPhoneBook + newPairing)

  // println(styledPhoneBook.contains("Mary"))  // NoSuchElementException: key not found
  // But there are a nice workaround (similar to Python's default_dict
  val defaultPhoneNumber = Map("Rose" -> 111).withDefaultValue(0)
  println(defaultPhoneNumber("Mary"))

  // funtionaos on maps
  // map, flatMap, filter iterate over PAIRS
  println(phoneBook.map(pair => pair._1.toLowerCase -> pair._2))

  // filterKeys iterate over KEYS only
  println(phoneBook.view.filterKeys(k => k.startsWith("J")).toMap)

  // mapValues iterate over VALUES only
  println(phoneBook.view.mapValues(v => s"+55 11 9${v}").toMap)

  // Conversions to other collections
  println(phoneBook.toList)
  println(List(("Daniel",123), ("Jim",555)).toMap)

  val names = List("Ana", "Bob", "Angela", "Brian")
  println(names.groupBy(name => name.charAt(0)))

  // Social Network Exercise
    case class SocialNetwork(population: Map[String, List[String]] = Map()) {
      def add(p: String) = SocialNetwork(this.population + (p -> List()))

      def remove(p: String) = SocialNetwork(this.population.removed(p))

      def friend(p: String, f: String) = {
        val pNewPair = p -> (this.population(p) :+ f)
        val fNewPair = f -> (this.population(f) :+ p)
        SocialNetwork(this.population + pNewPair + fNewPair)
      }

      def unfriend(p: String, f: String) = {
        val pNewPair = p -> (this.population(p).filter(_ != f))
        val fNewPair = f -> (this.population(f).filter(_ != p))

        SocialNetwork(this.population + pNewPair + fNewPair)
      }

      def numberOfFriends(p: String): Int = this.population(p).size

      def mostFriends: String = {
        this.population.reduce(
          (a, b) => {
            if a._2.size > b._2.size then a
            else b
          }
        )._1
      }

      def noFriendsCount: Int = {
        this.population.count(_._2.isEmpty)
      }

      def connectionBetween(p: String, f: String): Boolean = {
        def inner(current: String, pf: List[String], f: String, visited: List[String]): Boolean = {
          if (pf.isEmpty) false
          else if (pf.contains(f)) true
          else {
            pf.exists(next =>
              inner(next, this.population(next).filterNot(visited.contains), f, visited :+ current)
            )
          }
        }

        inner(p, this.population(p), f, List())
      }
    }



    val s = SocialNetwork()
      .add("Thiago")
      .add("Emily")
      .add("Cacau")
      .add("Max")
      .add("Gaspar")
      .friend("Thiago", "Emily")
      .friend("Thiago", "Max")
      .friend("Emily", "Cacau")
      .friend("Cacau", "Max")
      .unfriend("Max", "Cacau")

    println(s)
    println(s.numberOfFriends("Thiago"))
    println(s.mostFriends)
    println(s.noFriendsCount)
    println(s.connectionBetween("Thiago", "Cacau"))
    println(s.connectionBetween("Thiago", "Gaspar"))
}
