package exercises

abstract class AbstractMyList[+A] {
  /*
    linked list implementation with the following methods
    - head: first element of the list
    - tail: remainder of the list
    - isEmpty: boolean = true if there are no value on the collection
    - add(int): returns a new list with this element added
    - toString: returns a string representation of the list
  */

  def head: A
  def tail: AbstractMyList[A]
  def isEmpty: Boolean
  def add[B >: A](n: B): AbstractMyList[B]
  def printElements: String
  override def toString: String = s"[${printElements}]"
}

object NullObjectList extends AbstractMyList[Nothing] {
  def head: Nothing = throw new NoSuchElementException()
  def tail: MyList[Nothing] = throw new NoSuchElementException()
  def isEmpty: Boolean = true
  def add[B >: Nothing](n: B): MyList[B] = new MyList(n, NullObjectList)
  def printElements: String = ""
}

class MyList[+A](h: A, t: AbstractMyList[A]) extends AbstractMyList[A] {
  def head: A = h
  def tail: AbstractMyList[A] = t
  def isEmpty: Boolean = false
  def add[B >: A](n: B): MyList[B] = new MyList(n, this)
  def printElements: String = {
    val s = h.toString

    if (tail.isEmpty) s
    else s"$s, " + tail.printElements
  }
}

object ListTest extends App {
  val list: MyList[Int] = MyList(1, NullObjectList)

  println(list.head)
  println(list.isEmpty)
  println(list.add(42).head)
  println(list.toString)
  println(list.add(42).toString)

  val anotherList: MyList[String] = MyList("1", NullObjectList)

  println(anotherList.head)
  println(anotherList.isEmpty)
  println(anotherList.add("42").head)
  println(anotherList.toString)
  println(anotherList.add("42").toString)
}