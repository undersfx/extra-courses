package lectures.part2oop

import java.time.Year

object OOBasicsExercice02 extends App {
  /*
    Counter class

    Counter: value (int)
      methods:
        - current count
        - increment -> returns new Counter
        - decrement -> returns new Counter
        - overload inc/dec to receive a value of the amount
  */
  val counter: Counter = new Counter(1)
  println(s"current ${counter.currentCount()}")
  println(s"plus one ${counter.increment().currentCount()}")
  println(s"minus one ${counter.decrement().currentCount()}")

  val anotherCounter: Counter = new Counter(10)
  println(s"current ${anotherCounter.currentCount()}")
  println(s"plus hundred ${anotherCounter.increment(100).currentCount()}")
  println(s"minus fifty ${anotherCounter.decrement(50).currentCount()}")
}

class Counter(val value: Int = 0) {
  def currentCount(): Int = {
    value
  }

  def increment(): Counter = {
    Counter(this.value + 1)
  }

  def increment(value: Int): Counter = {
    Counter(this.value + value)
  }

  def decrement(): Counter = {
    Counter(this.value - 1)
  }

  def decrement(value: Int): Counter = {
    Counter(this.value - value)
  }
}


