package lectures.part2oop

object Generics extends App {
  // defining a generic typed class
  class MyList[A] {
   // use the type A
   def add[B >: A](element: B): MyList[B] = ???
  }

  // using a generic typed class
  val listOfIntegers: MyList[Int] = new MyList[Int]
  val listOfStrings = new MyList[String]

  // defining generic methods
  object MyList {
   def empty[A]: MyList[A] = {
     MyList[A]
   }
  }

  // using a generic typed methods
  val emptyListOfIntegers = MyList.empty[Int]


  // VARIANCE PROBLEM
  class Animal
  class Cat extends Animal
  class Dog extends Animal

  // 1. Covariance
  class CovariantList[+A]  // Accepts any Animal
  val animal: Animal = new Cat
  val animalList: CovariantList[Animal] = new CovariantList[Cat]

  // 2. Invariance
  class InvariantList[A]  // Only accepts Animals
  // val invariantAnimalList: InvariantList[Animal] = new InvariantList[Cat]  // < ERROR
  val invariantAnimalList: InvariantList[Animal] = new InvariantList[Animal]  // < OK

  // 3. Contravariance (a.k.a HELL NO!)
  class ContravariantList[-A]  // Only accepts generic Animals
  // val catTrainer: ContravariantList[Animal] = new ContravariantList[Cat]  // < ERROR
  val animalTrainer: ContravariantList[Cat] = new ContravariantList[Animal]
  val anotherAnimalTrainer: ContravariantList[Animal] = new ContravariantList[Animal]


  // What if...
  // animalList.add(new Dog) ???
  // Response: Would return a CovariantList[Animal]
  // Would need to use type bounds to solve the contravariance problem, see line 7 implementation.

  // Bounded Types
  class Cage[A <: Animal](animal: A)  // Accepts subtypes of Animal
  val dogCage = new Cage(new Dog)

  // class Lion
  // val lionCage = new Cage(new Lion)  // ERROR
}
