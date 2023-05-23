package lectures.part1basics

import scala.annotation.tailrec

object Recursion extends App {

  // each recursive call uses a stack frame
  def factorial(n: Int): Int = {
    if (n <= 1) 1
    else {
      println("computing factorial of " + n + " - I first need a factorial of " + (n - 1))
      val result = n * factorial(n - 1)
      println("computed factorial of " + n)
      result
    }
  }
  println(factorial(5))


  // tail rec uses same stack frame, no intermediary steps are saved (ie, theres an accumulator storing the intermediary results. In this case its the param, 'result'!
  // tail recursion = use recursive call as the LAST expression
  // you need x accumulators for how many recursive calls there are for tail rec. For Example, a tail rec fib methods needs two accumulators as there are two recursive calls
  @tailrec
  def factorialTailRecursion(n: Int, result: Int = 1): Int = {
    if (n <= 1) result
    else factorialTailRecursion(n - 1, n * result)
  }
  println(factorialTailRecursion(6))

}
