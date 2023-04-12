package lectures.part2oop

object MethoodNotationsExercice01 extends App {
  class Person(val name: String, favoriteMovie: String, val age: Int = 0) {
    def +(nickname: String): Person = Person(this.name + s" ($nickname)", favoriteMovie, this.age)
    def unary_+ : Person = Person(this.name, favoriteMovie, this.age + 1)
    def learns(thing: String): String = s"$name learns $thing"
    def learnsScala(): String = this learns "Scala"
    def apply(n: Int): Unit = println(s"$name watched $favoriteMovie $n times")
  }

  /*
    1. Overload the + operator with the current behaviour
    mary + "the rockstar" => new person with name "Mary (the rockstar)"

    2. Add an age attribute to the person
    Add a unary operator + that increments the persons age
    +mary => new Mary with the age increment

    3. Add a learns method in person class
    mary learns "Scala" => "Mary learns Scala"
    Add leansScala method that call method with "Scala"
    Use with the postfix notation.

    4. Overload the apply method
    mary.apply(2) => Mary watched Inception 2 times"
  */

  val mary = Person("Mary", "Inception", 33)
  val maryRockstar = +mary + "the rockstar"

  // 1
  println(maryRockstar.name)

  // 2
  println(mary.age)
  println(maryRockstar.age)

  // 3
  println(maryRockstar learns "to play Guitar")
  // DEPRECATED
  //  println(maryRockstar learnsScala)

  // 4
  mary.apply(1)
  mary(2)
}
