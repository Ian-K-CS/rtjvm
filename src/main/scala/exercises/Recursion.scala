package exercises

import scala.annotation.tailrec

object Recursion extends App {

  /*
  QUESTIONS

  1. Concatenate string function n times using tail recursion
  2. isPrime that's tail recursive
  3. Fib function that's tail recursive
  */


  // ANSWERS

  // 1.
  @tailrec
  def stringConcat(input: String, n: Int, result: String = ""): String = {
    if (n == 0) result
    else stringConcat(input, n - 1, input + " " + result)
  }

  println(stringConcat("hello", 5))


  // 2.
  def isPrime(n: Int): Boolean = {
    @tailrec
    def isPrimeUntil(t: Int, result: Boolean = true): Boolean = {
      if (t <= 1) result
      else isPrimeUntil(t - 1, n % t != 0 && result)
    }
    isPrimeUntil(n / 2)
  }
  println(isPrime(2003))
  println(isPrime(629))


  // 3.
  @tailrec
  def fib(n: Int, prevStep: Int = 1, prevTwoSteps: Int = 1): Int = {
    if (n <= 2) prevTwoSteps
    else fib(n - 1, prevTwoSteps, prevTwoSteps + prevStep)
  }
  println(fib(8))

  // fib(7, 1, 2)
  // fib(6, 2, 3)
  // fib(5, 3, 5)
  // fib(4, 5, 8)
  // fib(3, 8, 13)
  // fib(2, 13, 21)

}
