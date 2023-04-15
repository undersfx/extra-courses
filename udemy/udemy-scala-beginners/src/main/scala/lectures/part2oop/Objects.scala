package lectures.part2oop

object Objects {

  // SCALA DOES NOT HAVE CLASS-LEVEL FUNCTIONALITY

  object Person {
    // static or class functionality goes on object
    val N_EYES: Int = 2
    val canFly: Boolean = false
    def apply(mother: Person, father: Person): Person = new Person("Bobby")
  }

  class Person(val name: String) {
    // instance-level functionality
    def greet(): String = s"Hi, my name is $name"
  }
  // those two Person definitions together are called COMPANIONS


  // Scala objects are SINGLETONS
  val mary = Person
  val john = Person
  println(s"Is object mary equals john ? ${mary == john}")

  // Class instances are not SINGLETONS
  val gwen = new Person("Gwen")
  val joe = new Person("Joe")
  println(s"Is class instance gwen equals joe ? ${gwen == joe}")

  // class functionality access
  println(Person.N_EYES)
  // println(Person.greet())  // Error

  // instance functionality access
  println(gwen.greet())
  // println(gwen.N_EYES)  // Error

  // factory method using apply syntatic sugar
  val boobie: Person = Person(gwen, joe)
  println(boobie.greet())


  // Scala Applications (extends App) is a object with the method:
  // def main(args: Array[String]): Unit
  def main(args: Array[String]): Unit = {
    println("hello from main method")
  }
}
