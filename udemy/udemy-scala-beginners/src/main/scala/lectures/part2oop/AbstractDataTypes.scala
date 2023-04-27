package lectures.part2oop

object AbstractDataTypes extends App {
  // abstract
  //  -> classes that contain unimplemented fields or methods
  abstract class Animal {
    val creatureType: String = "Wild"
    def eat: Unit
  }

  // val unknowAnimal = new Animal  // Can not be instantiated

  class Dog extends Animal {
    override val creatureType: String = "Canine"  // Non-Abstract members need override keyword to be overwritten
    def eat: Unit = println("crunch! crunch!")
  }

  // traits
  //  ->
  trait Carnivore {
    val favoriteMeal: String = "Fresh Meat"
    def eat(animal: Animal): Unit
  }

  trait ColdBlooded

  class Crododile extends Animal with Carnivore with ColdBlooded {
    override val creatureType: String = "Croc"
    override def eat: Unit = println("Nom! Nom!")
    override def eat(animal: Animal): Unit = println(s"$creatureType is eacting ${animal.creatureType}")
  }

  val croc = new Crododile
  val dog = new Dog

  println(croc.favoriteMeal)
  croc.eat(dog)

  // traits vs abstract classes
  // - traits do not have constructor parameters
  // - you can only inherit one class, but multiple traits (single vs multiple inheritance)
  // - traits should explain behavior, abstract class are types
}
