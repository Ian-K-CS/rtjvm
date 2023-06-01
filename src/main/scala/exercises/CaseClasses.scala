package exercises

/*
  QUESTIONS
  Expand MyList4 - use case classes and case objects
 */

case object CaseClasses extends App {

  val listOfIntegers: MyList4[Int] = NonEmpty4(1, NonEmpty4(2, NonEmpty4(3, Empty4)))
  val anotherListOfIntegers: MyList4[Int] = NonEmpty4(4, NonEmpty4(5, Empty4))

  println(listOfIntegers.map(new MyTransformer2[Int,Int] {
    override def transform(input: Int): Int = input * 2
  }))

  println(listOfIntegers.filter(new MyPredicate2[Int] {
    override def test(x: Int): Boolean = x % 2 == 0
  }))

  println(listOfIntegers ++ anotherListOfIntegers)

  println(listOfIntegers.flatMap(new MyTransformer2[Int, MyList4[Int]] {
    override def transform(input: Int): MyList4[Int] = NonEmpty4(input, new NonEmpty4[Int](input + 1, Empty4))
  }))

}



trait MyPredicate2[-T] {
  def test(x: T): Boolean
}

trait MyTransformer2[-A, B] {
  def transform(input: A): B
}

abstract class MyList4[+A] {
  def head: A
  def tail: MyList4[A]
  def isEmpty: Boolean
  def add[B >: A](element: B): MyList4[B]
  def printElements: String
  override def toString: String = "[" + printElements + "]"

  def map[B](transformer: MyTransformer2[A, B]): MyList4[B]
  def filter(predicate: MyPredicate2[A]): MyList4[A]
  def flatMap[B](transformer: MyTransformer2[A, MyList4[B]]): MyList4[B]
  // concatenation
  def ++[B >: A](list: MyList4[B]): MyList4[B]

}

case object Empty4 extends MyList4[Nothing] {
  override def head: Nothing = throw new NoSuchElementException()
  override def tail: MyList4[Nothing] = throw new NoSuchElementException()
  override def isEmpty: Boolean = true
  override def add[B >: Nothing](element: B): MyList4[B] = NonEmpty4(element, Empty4)
  override def printElements: String = ""

  override def map[B](transformer: MyTransformer2[Nothing, B]): MyList4[B] = Empty4
  override def filter(predicate: MyPredicate2[Nothing]): MyList4[Nothing] = Empty4
  override def flatMap[B](transformer: MyTransformer2[Nothing, MyList4[B]]): MyList4[B] = Empty4
  override def ++[B >: Nothing](list: MyList4[B]): MyList4[B] = list
}

case class NonEmpty4[+A](h: A, t: MyList4[A]) extends MyList4[A] {
  override def head: A = h
  override def tail: MyList4[A] = t
  override def isEmpty: Boolean = false
  override def add[B >: A](element: B): MyList4[B] = NonEmpty4(element, this)
  override def printElements: String = {
    if (t == Empty4) s"$h"
    else h + " " + t.printElements
  }

  override def filter(predicate: MyPredicate2[A]): MyList4[A] = {
    if (predicate.test(h)) NonEmpty4(h, t.filter(predicate))
    else t.filter(predicate)
  }

  override def map[B](transformer: MyTransformer2[A, B]): MyList4[B] = {
    NonEmpty4(transformer.transform(h), t.map(transformer))
  }

  override def ++[B >: A](list: MyList4[B]): MyList4[B] = NonEmpty4(h, t ++ list)

  def flatMap[B](transformer: MyTransformer2[A, MyList4[B]]): MyList4[B] = transformer.transform(h) ++ t.flatMap(transformer)

}
