package lectures.part2oop

object MethodNotations extends App {
  class Person(val name: String, favoriteMovie: String) {
    def likes(movie: String): Boolean = movie == favoriteMovie

    // Ignore this until read section #2
    def +(person: Person): String = s"${this.name} is hanging out with ${person.name}"

    // Ignore this until read section #3
    def unary_! : String = s"${this.name} says: What the heck ?!"

    // Ignore this until read section #4
    def isAlive: Boolean = true

    // Ignore this until read section #5
    def apply(): String = s"Hi, my name is $name and I like $favoriteMovie"
  }

  // 0. Normal method call notation
  val mary = new Person("Mary", "Inception")
  println(mary.likes("Inception"))


  // 1. Infix notation (or Operator notation)
  println(mary likes "Inception") // (only works for single arg methods (arity-1)


  // 2. Operators in Scala are methods
  val tom = new Person("tom", "Fight Club")
  println(mary + tom)
  println(mary.+(tom))

  // ALL OPERATORS ARE METHODS
  println(1 + 2)
  println(1.+(2))


  // 3. Prefix Notation
  println(-1)         // "-" operator is a unary operator method from object 1
  println(1.unary_-)  // Proof

  println(!mary)
  println(mary.unary_!)  // Be aware of the difference in the method definition! (line 11)


  // 4. Postfix notation
  println(mary.isAlive)
  //  DEPRECATED
  //  println(mary isAlive)  // (only works for no arg methods (arity-0)


  // 5. Apply method
  println(mary.apply())  // is equivalent to ...
  println(mary())
}
