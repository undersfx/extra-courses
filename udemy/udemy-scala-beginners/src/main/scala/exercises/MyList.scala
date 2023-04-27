package exercises

abstract class AbstractMyList {
  /*
    linked list implementation with the following methods
    - head: first element of the list
    - tail: remainder of the list
    - isEmpty: boolean = true if there are no value on the collection
    - add(int): returns a new list with this element added
    - toString: returns a string representation of the list
  */

  def head: Int
  def tail: AbstractMyList
  def isEmpty: Boolean
  def add(n: Int): AbstractMyList
  def printElements: String
  override def toString: String = s"[${printElements}]"
}

object NullObjectList extends AbstractMyList {
  def head: Int = throw new NoSuchElementException()
  def tail: MyList = throw new NoSuchElementException()
  def isEmpty: Boolean = true
  def add(n: Int): MyList = new MyList(n, NullObjectList)
  def printElements: String = ""
}

class MyList(val head: Int, val tail: AbstractMyList) extends AbstractMyList {
  def isEmpty: Boolean = false
  def add(n: Int): MyList = new MyList(n, this)
  def printElements: String = {
    val s = head.toString

    if (tail.isEmpty) s
    else s"$s, " + tail.printElements
  }
}

object ListTest extends App {
  val list = MyList(1, NullObjectList)

  println(list.head)
  println(list.isEmpty)
  println(list.add(42).head)
  println(list.toString)
  println(list.add(42).toString)
}