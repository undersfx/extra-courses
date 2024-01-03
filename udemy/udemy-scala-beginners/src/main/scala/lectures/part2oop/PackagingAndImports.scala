package lectures.part2oop

// CAUTION: This imports will execute their code when imported (Look at the terminal output)
import lectures.part1basics.{Functions, Recursion} // Multiple explicit imports
import lectures.part1basics.StringOps._            // Multiple implicit imports
import lectures.part1basics.{Expressions => Exp}   // Import Aliasing

object PackagingAndImports extends App {
  // package members are accessible by their name
  val writer: Writer = new Writer("Thiago", "FooBar", 2024)

  // fully qualified name call
  val res1 = lectures.part1basics.Recursion.factorial(3)

  // import a package outside local
  import lectures.part1basics.Recursion.factorial
  val res2 = factorial(3)

  // Packages follows the hierarchy of the folder structure
  //  src
  //   |-exercices
  //   |-lectures
  //        |-part1basics
  //        |-part2oop
  //   |-playground

  // Package Object
  // - One per package
  // - File named package.scala
  // - Object named as the same as the package they are in (e.g. part2oop would have 'package object part2oop')
  // - Methods and Attributes on package object are visible on package members by their name
  sayHello
  println(SPEED_OF_LIGHT)
}
