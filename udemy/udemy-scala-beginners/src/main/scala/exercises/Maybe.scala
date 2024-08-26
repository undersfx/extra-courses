package exercises

abstract class Maybe[+T] {
  /*
    Lecture 29 Exercise
   */
}

case object MaybeNot extends Maybe[Nothing] {
  override def toString: String = "Maybe(Nothing)"
  def map[B](f: Nothing => B): Maybe[B] = MaybeNot
  def flatMap[B](f: Nothing => Maybe[B]): Maybe[B] = MaybeNot
  def filter(p: Nothing => Boolean): Maybe[Nothing] = MaybeNot
}

class Just[+T](value: T) extends Maybe[T] {
  override def toString: String = s"Maybe(${this.value})"

  def map[B](f: T => B): Just[B] = Just(f(this.value))

  def flatMap[B](f: T => Maybe[B]): Maybe[B] = f(this.value)

  def filter(predicate: T => Boolean): Maybe[T] =
    if (predicate(this.value)) then this else MaybeNot
}

object Main extends App {
  val m1 = Just[Int](1)

  println(m1.map(_ + 1))
  println(m1.flatMap((x: Int) => Just[Int](x + 10)))
  println(m1.filter(y => false))
}