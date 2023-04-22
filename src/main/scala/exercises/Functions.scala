package exercises

import scala.annotation.tailrec

object Functions extends App {

  /*
  QUESTIONS

  1. write a greeting function, take 2 params (name, age) => "Hi, my name is $name and I am $age years old.
  2. write a factorial function 1 * 2 * 3 * 4 ..... etc (computes product of all numbers up to n) - this will be recursive
  3. write a fibonacci function:
    f(1) = 1
    f(2) = 1
    f(n) = f(n - 1) + f(n - 2)
  4. Test if a number is prime.

   */


  // ANSWERS

  // 1.
  def greeting(name: String, age: Int): String = {
    s"Hi, my name is $name and I am $age years old."
  }
  println(greeting("zack", 22))

  // 2.
  def factorial(n: Int): Int = {
    if (n == 0) 1
    else n * factorial(n - 1)
  }
  println(factorial(5))

  // tail recursive example
  @tailrec
  def tailRecursiveFactorial(n: Int, result: Int): Int = {
    if (n == 0) result
    else tailRecursiveFactorial(n - 1, result * n)
  }
  println(factorial(5))

  // 3.
  def fibonacci(n: Int): Int = {
    if (n <= 2) 1
    else fibonacci(n - 1) + fibonacci(n - 2)
  }
  println(fibonacci(8))

  // 4.
  def isPrime(n: Int): Boolean = {
    val range: Seq[Int] = 2.to(n).toList
    val primeCheck: Int = range.map(n % _ == 0).count(x => x)

    if (n > 1 && primeCheck == 1) true
    else false
  }
  println(isPrime(17))

}

