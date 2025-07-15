package lectures.part3functional

import scala.util.Random

object Sequences extends App {
  // Sequences
  val aSeq: Seq[Int] = Seq(1, 2, 3)

  println(aSeq) // Seq.apply method is a factory will create a List(1, 2, 3)
  println(aSeq.reverse)
  println(aSeq(2)) // aSeq.apply method here will get item in index 2
  println(aSeq ++ Seq(9, 8, 7))
  println(aSeq ++ Seq(9, 8, 7).sorted)

  // Ranges
  val aRange: Seq[Int] = 1 to 10 // or 1.to(10)

  println(aRange)
  aRange.foreach(println)


  // Lists
  val aList: List[Int] = List(1, 2, 3)
  println(aList)

  println(0 +: aList) // prepend
  println(aList :+ 4) // append
  println(0 +: aList :+ 4)

  val apples: List[String] = List.fill(5)("apple") // curried constructor
  println(apples)
  println(apples.mkString("-"))


  // Arrays
  val threeStringElements: Array[String] = Array.ofDim[String](3)
  threeStringElements.foreach(println)

  val threeIntElements: Array[Int] = Array.ofDim[Int](3)
  threeIntElements.foreach(println)

    // mutation
  val numbers: Array[Int] = Array(1, 2, 3)
  numbers(2) = 0 // syntax sugar for numbers.update(2, 0)
  println(numbers.mkString(", "))

    // how Array relate to Seqs ?
  val numberSeq: Seq[Int] = numbers // equal sign here works as an implicit conversion from Array to Seq
  println(numberSeq)


  // Vectors
  val vector: Vector[Int] = Vector(1, 2, 3)
  println(vector)

  def getWriteTime(collection: Seq[Int], maxRuns: Int, maxCapacity: Int): Double = {
    val r = new Random
    val times = for {
      it <- 1 to maxRuns
    } yield {
      val currentTime = System.nanoTime()
      collection.updated(r.nextInt(maxCapacity), 0)
      System.nanoTime() - currentTime
    }
    (times.sum * 1.0) / maxRuns
  }

  val maxCapacity: Int = 1000000

  // List keeps reference to tail, updating a element in the middle is slow
  println(getWriteTime((1 to maxCapacity).toList, 1000, maxCapacity))

  // Vector has small tree depth (32-elements), but need to replace the entire chunk when updated
  println(getWriteTime((1 to maxCapacity).toVector, 1000, maxCapacity))
}
