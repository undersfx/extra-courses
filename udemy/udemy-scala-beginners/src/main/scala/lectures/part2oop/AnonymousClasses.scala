package lectures.part2oop

object AnonymousClasses extends App {

  abstract class Animal {
    def speak: Unit
  }

  val funnyAnimal = new Animal {  // Instantiation of a abstract class ???
    override def speak: Unit = println("haha!")
  }
  funnyAnimal.speak
  /*
  What actualy happens under the hood:

  class AnonymousClasses$$anon$1 extends Animal {
    override def speak: Unit = println("haha!")
  }
  val funnyAnimal = new AnonymousClasses$$anon$1
  */
  println(funnyAnimal.getClass)

  // Same with traits

  trait Carnivore {
    def eat: Unit
  }

  val predator = new Carnivore {
    override def eat: Unit = println("Nom, Nom!")
  }
  predator.eat


  // Caution with Classes that have init parameters
  class Person(name: String) {
    def introduce: Unit = println(s"Hi my name is $name")
  }

//  val jim = new Person {  // <- ERROR
//    override def introduce: Unit = println(s"Hi my name is Jim")
//  }

  val jimmy = new Person("Jimmy") {  // Needs init parameter
    override def introduce: Unit = println(s"Hi my name is Jim")
  }
  jimmy.introduce
}
