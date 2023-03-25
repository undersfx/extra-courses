package lectures.part2oop

object OOBasics extends App {
  val person = new Person("Thiago", 42)
  println(person)
  println(person.x)
  println(person.age)
  //  println(person.name) // will throw an error due to not being called as val in the constructor

  person.greet()
  person.greet("Emily")  // overloaded method

  val bebe = new Person("Luiz")
  println(bebe.age)
  bebe.greet()

  val fulano = new Person()
  println(fulano.age)
  fulano.greet()
}

// constructor
class Person(name: String, val age: Int) { // val on age makes it an attribute
  // makes x also an attribute
  val x = 2

  // this collateral effect will occur on every instantiation of Person
  println("Creating another person")

  // method
  def greet(): Unit = {
    // name implicit refers to constructor name argument
    println(s"Hi, my name is $name")
  }

  // different list of arguments "overloads" the method
  // different implementation with the same method name
  def greet(name: String): Unit = {
    // existence of method arg with the same name requires this.name remove ambiguity
    println(s"${this.name} says: Hi $name!")
  }

  // auxiliary constructors overloads the constructor method
  def this(name: String) = this(name, 0)
  def this() = this("Fulano", 0)
}