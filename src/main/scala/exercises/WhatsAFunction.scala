package exercises

/*
  QUESTIONS
  1. a function that takes 2 strings and concatenates them
  2. transform MyPredicate & MyTransformer into function types.
  3. define a function which takes an arg: Int, and returns another function which takes an Int and returns an Int
    - define whats the type of this function
    - how do you implement this?
*/

object WhatsAFunction extends App {

  // ANSWERS
  // 1.
  def aConcatenationFunction: (String, String) => String = new Function2[String, String, String] {
    override def apply(str1: String, str2: String): String = str1 + " " + str2
  }
  println(aConcatenationFunction("hello", "world"))


  // 2.
  val listOfIntegers: MyList6[Int] = NonEmpty6(1, NonEmpty6(2, NonEmpty6(3, Empty6)))
  val anotherListOfIntegers: MyList6[Int] = NonEmpty6(4, NonEmpty6(5, Empty6))

  println(listOfIntegers.map(new Function1[Int, Int] {
    override def apply(input: Int): Int = input * 2
  }))

  println(listOfIntegers.filter(new Function1[Int, Boolean] {
    override def apply(x: Int): Boolean = x % 2 == 0
  }))

  println(listOfIntegers ++ anotherListOfIntegers)

  println(listOfIntegers.flatMap(new Function1[Int, MyList6[Int]] {
    override def apply(input: Int): MyList6[Int] = NonEmpty6(input, new NonEmpty6[Int](input + 1, Empty6))
  }))


  // 3.
  // A curried Function
  def aCurriedFunction: Int => Int => Int = {
    new Function1[Int, Function1[Int, Int]] {
      override def apply(x: Int): Int => Int = {
        new Function1[Int, Int] {
          override def apply(y: Int): Int = x + y
        }
      }
    }
  }
  val testingHigherOrderFunction = aCurriedFunction(3) // this returns a function1
  println(testingHigherOrderFunction)
  println(testingHigherOrderFunction(5)) // this returns 8. So it does the 3 + 8

  // can also write
  println(aCurriedFunction(20)(5)) // a curried function - can be called with multiple parameters

}


/*
  this is basically Function1[A, R] => R
  takes in a type T and returns R (a Boolean type)

  trait MyPredicate4[-T] {
    def test(x: T): Boolean
  }



  this is basically Function1[A, B] => B
  takes in a type A, and returns type B

  trait MyTransformer4[-A, B] {
    def transform(input: A): B
  }
*/

abstract class MyList6[+A] {
  def head: A
  def tail: MyList6[A]
  def isEmpty: Boolean
  def add[B >: A](element: B): MyList6[B]
  def printElements: String
  override def toString: String = "[" + printElements + "]"

  // higher order functions - takes in a function or returns a function
  def map[B](transformer: A => B): MyList6[B]
  def filter(predicate: A => Boolean): MyList6[A]
  def flatMap[B](transformer: A => MyList6[B]): MyList6[B]

  // concatenation
  def ++[B >: A](list: MyList6[B]): MyList6[B]

}

case object Empty6 extends MyList6[Nothing] {
  override def head: Nothing = throw new NoSuchElementException()
  override def tail: MyList6[Nothing] = throw new NoSuchElementException()
  override def isEmpty: Boolean = true
  override def add[B >: Nothing](element: B): MyList6[B] = NonEmpty6(element, Empty6)
  override def printElements: String = ""

  override def map[B](transformer: Nothing => B): MyList6[B] = Empty6
  override def filter(predicate: Nothing => Boolean): MyList6[Nothing] = Empty6
  override def flatMap[B](transformer: Nothing => MyList6[B]): MyList6[B] = Empty6
  override def ++[B >: Nothing](list: MyList6[B]): MyList6[B] = list
}

case class NonEmpty6[+A](h: A, t: MyList6[A]) extends MyList6[A] {
  override def head: A = h
  override def tail: MyList6[A] = t
  override def isEmpty: Boolean = false
  override def add[B >: A](element: B): MyList6[B] = NonEmpty6(element, this)
  override def printElements: String = {
    if (t == Empty6) s"$h"
    else h + " " + t.printElements
  }

  override def filter(predicate: A => Boolean): MyList6[A] = {
    if (predicate(h)) NonEmpty6(h, t.filter(predicate))
    else t.filter(predicate)
  }

  override def map[B](transformer: A => B): MyList6[B] = {
    NonEmpty6(transformer(h), t.map(transformer))
  }

  override def ++[B >: A](list: MyList6[B]): MyList6[B] = NonEmpty6(h, t ++ list)

  def flatMap[B](transformer: A => MyList6[B]): MyList6[B] = transformer(h) ++ t.flatMap(transformer)

}
