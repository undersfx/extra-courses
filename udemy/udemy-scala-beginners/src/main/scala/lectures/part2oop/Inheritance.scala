package lectures.part2oop

object Inheritance extends App {
  // SINGLE CLASS INHERITANCE

  // Superclass of Cat
  class Animal {
    val creatureType = "wild"
    def eat: Unit = println("nom! nom!")
    private def walk = println("step, step.")
    protected def speak(sound: String) = println(s"$sound! $sound!")
  }

  // Subclass of Animal
  class Cat extends Animal {
    def meow(): Unit = {
      speak("Meow")  // Protected methods can be used inside the class
    }
  }

  val cat = new Cat
  cat.eat       // Inherited Functionality
  println(s"cat is a ${cat.creatureType} animal")
  // cat.walk   // ERROR: Private methods are NOT inherited

  cat.meow()
  // cat.speak("Meow") // ERROR: Protected methods can NOT be used publicly


  // OVERRIDING
  class Dog extends Animal {
    override val creatureType: String = "domestic"
    override def eat = {
      println("Dog starts to eat")
      super.eat
    }
  }

  val dog = new Dog()
  dog.eat
  println(s"dog is a ${dog.creatureType} animal")

  // another way of overriding
  class unknowAnimal(override val creatureType: String) extends Animal

  val dinossaur = new unknowAnimal("extinct")
  println(s"dinossaur is a ${dinossaur.creatureType} animal")


  // OVERLOADING
  class Lion extends Animal {
    def eat(food: String): Unit = println(s"eating a $food")  // same method but overloaded with different params
  }

  val lion: Lion = new Lion()
  lion.eat("Deer")

  // POLYMORPHISM
  val anotherAnimal: Animal = new Dog  // type substitution
  anotherAnimal.eat  // will use overwritten method from Dog even being of type Animal


  // CONSTRUCTOR
  class Person(name: String, age: Int) {
    def this(name: String) = this(name, 0)
  }

  // class Adult(name: String, age: Int, idCard: String) extends Person  // This will not compile due to missing params
  class Adult(name: String, age: Int, idCard: String) extends Person(name, age)  // or Person(name)


  // preventing overrides
  // 1 - use final in the desired method
  // 2 - use final in the entire class
  // 3 - use sealed in class => will be only overwritten by classes in the same file
}
