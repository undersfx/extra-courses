package lectures.part3functional

object MapFlatmapFilterFor extends App {

  var list = List(1, 2, 3)
  println(list)

  // map
  println(list.map(_ + 1))
  println(list.map(_ + "is a number"))

  // filter
  println(list.filter(_ % 2 == 0))

  // flatMap
  val toPair = (x: Int) => List(x, x + 1)  // makes a nested result
  println(list.map(toPair))
  println(list.flatMap(toPair))

  // foreach
  list.foreach(println)


  // exercice: print all combinations between two lists
  val numbers = List(1, 2, 3)
  val chars = List('a', 'b', 'c')
  val colors = List("R", "G", "B")
  // List("a1R", ... "c3B")

  println(chars.flatMap((c) => numbers.flatMap((n) => colors.map(color => s"$c$n$color"))))  // gets complex fast

  // for-comprehensions to save us
  val combinations = for {
    n <- numbers
    c <- chars
    color <- colors
  } yield s"$c$n$color"
  println(combinations)

  for {
    n <- numbers if n % 2 == 0
    c <- chars
    color <- colors if color == "B"
  } println(s"$c$n$color")

  // syntax overload
  println {
    list.map { x =>
      x * 2
    }
  }

  /*
    1. MyList supports for comprehensions ?
    2. Implement a small collection of at most ONE element (Maybe[+T]) with methods map, flatMap and filter
  */

  // 1
  import exercises.{MyList, NullObjectList}

  val myListNumbers = MyList(1, MyList(2, MyList(3, NullObjectList)))
  val myListChars = MyList('a', MyList('b', MyList('c', NullObjectList)))

  for {
    n <- myListNumbers
    c <- myListChars
  } println(s"$n$c")  // WOW! it works!
  
  // 2. -> goto: Maybe.scala
}
