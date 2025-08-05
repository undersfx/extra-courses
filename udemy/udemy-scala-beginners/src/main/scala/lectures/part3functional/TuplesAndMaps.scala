package lectures.part3functional

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
}
