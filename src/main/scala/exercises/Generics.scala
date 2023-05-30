package exercises

// QUESTIONS
// 1. expand the abstract class MyList to be generic

object Generics extends App {

  val listOfIntegers1: MyList2[Int] = Empty2
  println(listOfIntegers1)

  val listOfIntegers2: MyList2[String] = Empty2
  println(listOfIntegers2)

  val listOfIntegers3: MyList2[Double] = new NonEmpty2[Double](99.99, Empty2)
  println(listOfIntegers3)
  val listOfIntegers4 = listOfIntegers3.add(55.55)
  println(listOfIntegers4.toString)

}
// ANSWER
abstract class MyList2[+A] {
  def head: A
  def tail: MyList2[A]
  def isEmpty: Boolean
  def add[B >: A](element: B): MyList2[B]

  def printElements: String

  override def toString: String = "[" + printElements + "]"
}

object Empty2 extends MyList2[Nothing] {
  override def head: Nothing = throw new NoSuchElementException()
  override def tail: MyList2[Nothing] = throw new NoSuchElementException()
  override def isEmpty: Boolean = true
  override def add[B >: Nothing](element: B): MyList2[B] = new NonEmpty2(element, Empty2)

  override def printElements: String = ""
}

class NonEmpty2[+A](h: A, t: MyList2[A]) extends MyList2[A] {
  override def head: A = h
  override def tail: MyList2[A] = t
  override def isEmpty: Boolean = false
  override def add[B >: A](element: B): MyList2[B] = new NonEmpty2(element, this)

  override def printElements: String = {
    if (t == Empty2) s"$h"
    else h + " " + t.printElements
  }
}


