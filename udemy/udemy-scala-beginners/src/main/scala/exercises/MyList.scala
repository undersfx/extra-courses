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
  def map[B](transformer: MyTransformer[A, B]): AbstractMyList[B]
  def flatMap[B](transformer: MyTransformer[A, AbstractMyList[B]]): AbstractMyList[B]
  def filter(predicate: MyPredicate[A]): AbstractMyList[A]
  def ++[B >: A](list: AbstractMyList[B]): AbstractMyList[B]  // concatenation
}

object NullObjectList extends AbstractMyList[Nothing] {
  def head: Nothing = throw new NoSuchElementException()
  def tail: MyList[Nothing] = throw new NoSuchElementException()
  def isEmpty: Boolean = true
  def add[B >: Nothing](n: B): MyList[B] = new MyList(n, NullObjectList)
  def printElements: String = ""
  def map[B](transformer: MyTransformer[Nothing, B]): AbstractMyList[B] = NullObjectList
  def flatMap[B](transformer: MyTransformer[Nothing, AbstractMyList[B]]): AbstractMyList[B] = NullObjectList
  def filter(predicate: MyPredicate[Nothing]): AbstractMyList[Nothing] = NullObjectList
  def ++[B >: Nothing](list: AbstractMyList[B]): AbstractMyList[B] = list
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
  def map[B](transformer: MyTransformer[A, B]): AbstractMyList[B] =
    new MyList(transformer.transform(h), t.map(transformer))

  def flatMap[B](transformer: MyTransformer[A, AbstractMyList[B]]): AbstractMyList[B] =
    transformer.transform(h) ++ t.flatMap(transformer)

  def filter(predicate: MyPredicate[A]): AbstractMyList[A] =
    if (predicate.test(h)) then MyList(h, t.filter(predicate))
    else t.filter(predicate)

  def ++[B >: A](list: AbstractMyList[B]): AbstractMyList[B] = new MyList(h, t ++ list)
}


trait MyPredicate[-T] {
  def test(elem: T) : Boolean
}

trait MyTransformer[-A, B] {
  def transform(elem: A): B
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

  val numbersList = MyList(1, MyList(2, MyList(3, NullObjectList)))

  println(numbersList.filter(new MyPredicate[Int] {
      override def test(elem: Int): Boolean = elem % 2 == 0
    }).toString)

  println(numbersList.map(new MyTransformer[Int, Int] {
    override def transform(elem: Int): Int = elem * 2
  }).toString)

  println(list ++ numbersList)

  println(numbersList.flatMap(new MyTransformer[Int, AbstractMyList[Int]] {
    override def transform(elem: Int): AbstractMyList[Int] = new MyList(elem, new MyList(elem + 1, NullObjectList))
  }).toString)
}