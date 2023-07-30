package lectures.part2oop

object CaseClasses extends App {
  /*
    Case classes are classes with new features already implemented out of the box
  */

  class Person(name: String, age: Int)
  case class classyPerson(name: String, age: Int)

  val Jim = new Person("Jim", 42)
  val classyJim = new classyPerson("Jim", 42)

  // 1. class parameters are fields
  //  println(Jim.name)  <- ERROR: name is not a member of class Person by default
  println(classyJim.name)


  // 2. sensible toString method
  println(Jim)        // outputs: lectures.part2oop.CaseClasses$Person@74ad1f1f
  println(classyJim)  // outputs: classyPerson(Jim,42)
  // Remember: println(instance) = println(instance.toString)


  // 3. equals and hashCode auto-implemented
  println(Jim == classyJim)  // false

  val anotherClassyJim = new classyPerson("Jim", 42)
  println(classyJim == anotherClassyJim)  // true (throuth class hash, not identity)


  // 4. handy copy method
  val olderOfJim = classyJim.copy(age = 50)
  println(olderOfJim.age)


  // 5. companion object
  val classyPersonClass = classyPerson  // companion auto-created


  // 6. apply method auto-created
  val classyMary = classyPerson("Mary", 18)  // note the absence of "new" keyword

  // 7. Serializable
  // Usefull for network calls/distributed systems

  // 8. Extractor Patterns (PATTERN MATCHING)


  // Case Singletons can be created as case objects
  case object Animal {
    def name: String = "Max"
  }
}
