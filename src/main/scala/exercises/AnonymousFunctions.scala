package exercises

import lectures.part2oop.Generics.MyList

/*

  QUESTIONS

  1. MyList - replace all functionX calls with anon functions / lambdas
  2. Rewrite curried function as an anon function / lambdas.
  
*/

object AnonymousFunctions extends App {

  // ANSWERS
  // 1.
  val listOfIntegers: MyList7[Int] = NonEmpty7(1, NonEmpty7(2, NonEmpty7(3, Empty7)))
  val anotherListOfIntegers: MyList7[Int] = NonEmpty7(4, NonEmpty7(5, Empty7))
  println(listOfIntegers ++ anotherListOfIntegers)



  /*
    println(listOfIntegers.map(new Function1[Int, Int] {
      override def apply(input: Int): Int = input * 2
    }))
  */
  println(listOfIntegers.map(x => x * 2))
  // or ...
  println(listOfIntegers.map(_ * 2))



  /*
    println(listOfIntegers.filter(new Function1[Int, Boolean] {
      override def apply(x: Int): Boolean = x % 2 == 0
    }))
  */
  println(listOfIntegers.filter(x => x % 2 == 0))
  // or ...
  println(listOfIntegers.filter(_ % 2 == 0))



  /*
    println(listOfIntegers.flatMap(new Function1[Int, MyList7[Int]] {
      override def apply(input: Int): MyList7[Int] = NonEmpty7[Int](input, new NonEmpty7[Int](input + 1, Empty7))
    }))
  */
  println(listOfIntegers.flatMap(x => NonEmpty7(x, NonEmpty7(x + 1, Empty7))))





  // 2.

//  def aCurriedFunction: Int => Int => Int = {
//    new Function1[Int, Function1[Int, Int]] {
//      override def apply(x: Int): Int => Int = {
//        new Function1[Int, Int] {
//          override def apply(y: Int): Int = x + y
//        }
//      }
//    }
//  }


  val anonCurriedFunction: Int => Int => Int = (x: Int) => (y: Int) => x + y
  println(anonCurriedFunction(5)(5))

}


abstract class MyList7[+A] {
  def head: A
  def tail: MyList7[A]
  def isEmpty: Boolean
  def add[B >: A](element: B): MyList7[B]
  def printElements: String
  override def toString: String = "[" + printElements + "]"

  // higher order functions - takes in a function or returns a function
  def map[B](transformer: A => B): MyList7[B]
  def filter(predicate: A => Boolean): MyList7[A]
  def flatMap[B](transformer: A => MyList7[B]): MyList7[B]

  // concatenation
  def ++[B >: A](list: MyList7[B]): MyList7[B]

}

case object Empty7 extends MyList7[Nothing] {
  override def head: Nothing = throw new NoSuchElementException()
  override def tail: MyList7[Nothing] = throw new NoSuchElementException()
  override def isEmpty: Boolean = true
  override def add[B >: Nothing](element: B): MyList7[B] = NonEmpty7(element, Empty7)
  override def printElements: String = ""

  override def map[B](transformer: Nothing => B): MyList7[B] = Empty7
  override def filter(predicate: Nothing => Boolean): MyList7[Nothing] = Empty7
  override def flatMap[B](transformer: Nothing => MyList7[B]): MyList7[B] = Empty7
  override def ++[B >: Nothing](list: MyList7[B]): MyList7[B] = list
}

case class NonEmpty7[+A](h: A, t: MyList7[A]) extends MyList7[A] {
  override def head: A = h
  override def tail: MyList7[A] = t
  override def isEmpty: Boolean = false
  override def add[B >: A](element: B): MyList7[B] = NonEmpty7(element, this)
  override def printElements: String = {
    if (t == Empty7) s"$h"
    else h + " " + t.printElements
  }

  override def filter(predicate: A => Boolean): MyList7[A] = {
    if (predicate(h)) NonEmpty7(h, t.filter(predicate))
    else t.filter(predicate)
  }

  override def map[B](transformer: A => B): MyList7[B] = {
    NonEmpty7(transformer(h), t.map(transformer))
  }

  override def ++[B >: A](list: MyList7[B]): MyList7[B] = NonEmpty7(h, t ++ list)

  def flatMap[B](transformer: A => MyList7[B]): MyList7[B] = transformer(h) ++ t.flatMap(transformer)

}