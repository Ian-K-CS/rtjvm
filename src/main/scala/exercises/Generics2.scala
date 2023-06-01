package exercises

/*
  QUESTIONS
  expand MyList3 functionality

  1. Create generic trait 'MyPredicate[-T]'
    - method to test value of type T passes a condition. Every subclass of MyPredicate[T] will have a diff implementation
    - test(T) => Boolean

    eg:
    class EvenPredicate extends MyPredicate[Int]


  2. Generic trait called MyTransformer[-A, B]
    - method to convert value of type A to type B. every subclass of MyTransformer will have a diff implementation of the method
    - transform(A) => B

    eg:
    class StringToIntTransformer extends MyTransformer[String, Int]


  3. Implement the following on MyList3
    - map(transformer) => MyList3 of a different type
      - [1,2,3].map(n * 2) = [2,4,6]
    - filter(predicate) => MyList3
      - [1,2,3,4].filter(n % 2) = [2,4]
    - flatMap(transformer from A to MyList[B]) => MyList[B]
      - [1,2,3].flatMap(n => [n, n+1] => [1,2,2,3,3,4]

 */

object Generics2 extends App {
  val listOfIntegers: MyList3[Int] = new NonEmpty3(1, new NonEmpty3(2, new NonEmpty3(3, Empty3)))
  val anotherListOfIntegers: MyList3[Int] = new NonEmpty3(4, new NonEmpty3(5, Empty3))

  println(listOfIntegers.map(new MyTransformer[Int,Int] {
    override def transform(input: Int): Int = input * 2
  }))

  println(listOfIntegers.filter(new MyPredicate[Int] {
    override def test(x: Int): Boolean = x % 2 == 0
  })).toString

  println(listOfIntegers ++ anotherListOfIntegers)

  println(listOfIntegers.flatMap(new MyTransformer[Int, MyList3[Int]] {
    override def transform(input: Int): MyList3[Int] = new NonEmpty3(input, new NonEmpty3[Int](input + 1, Empty3))
  })).toString

}

trait MyPredicate[-T] {
  def test(x: T): Boolean
}

//class EvenPredicate extends MyPredicate[Int] {
//  override def test(x: Int): Boolean = x % 2 == 0
//}

trait MyTransformer[-A, B] {
  def transform(input: A): B
}

//class StringToIntTransformer extends MyTransformer[String, Int] {
//  override def transform(input: String): Int = input.toInt
//}

abstract class MyList3[+A] {
  def head: A
  def tail: MyList3[A]
  def isEmpty: Boolean
  def add[B >: A](element: B): MyList3[B]
  def printElements: String
  override def toString: String = "[" + printElements + "]"

  def map[B](transformer: MyTransformer[A, B]): MyList3[B]
  def filter(predicate: MyPredicate[A]): MyList3[A]
  def flatMap[B](transformer: MyTransformer[A, MyList3[B]]): MyList3[B]
  // concatenation
  def ++[B >: A](list: MyList3[B]): MyList3[B]

}

object Empty3 extends MyList3[Nothing] {
  override def head: Nothing = throw new NoSuchElementException()
  override def tail: MyList3[Nothing] = throw new NoSuchElementException()
  override def isEmpty: Boolean = true
  override def add[B >: Nothing](element: B): MyList3[B] = new NonEmpty3(element, Empty3)
  override def printElements: String = ""

  override def map[B](transformer: MyTransformer[Nothing, B]): MyList3[B] = Empty3
  override def filter(predicate: MyPredicate[Nothing]): MyList3[Nothing] = Empty3
  override def flatMap[B](transformer: MyTransformer[Nothing, MyList3[B]]): MyList3[B] = Empty3
  override def ++[B >: Nothing](list: MyList3[B]): MyList3[B] = list
}

class NonEmpty3[+A](h: A, t: MyList3[A]) extends MyList3[A] {
  override def head: A = h
  override def tail: MyList3[A] = t
  override def isEmpty: Boolean = false
  override def add[B >: A](element: B): MyList3[B] = new NonEmpty3(element, this)
  override def printElements: String = {
    if (t == Empty3) s"$h"
    else h + " " + t.printElements
  }

  override def filter(predicate: MyPredicate[A]): MyList3[A] = {
    if (predicate.test(h)) new NonEmpty3(h, t.filter(predicate))
    else t.filter(predicate)
  }

  override def map[B](transformer: MyTransformer[A, B]): MyList3[B] = {
    new NonEmpty3(transformer.transform(h), t.map(transformer))
  }

  override def ++[B >: A](list: MyList3[B]): MyList3[B] = new NonEmpty3(h, t ++ list)

  def flatMap[B](transformer: MyTransformer[A, MyList3[B]]): MyList3[B] = transformer.transform(h) ++ t.flatMap(transformer)

}
