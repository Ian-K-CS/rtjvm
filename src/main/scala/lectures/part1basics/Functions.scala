package lectures.part1basics

import scala.annotation.tailrec

object Functions extends App {

  def aFunction(a: String, b: Int): String = {
    a  + " " + b
  }

  println(aFunction("hello", 3))

  def aParameterlessFunction(): Int = 42
  println(aParameterlessFunction())
  println(aParameterlessFunction)
  // Can call a parameterless function with or without the param parenthesis

  def aRepeatedFunction(aString: String, n: Int): String = {
    if (n == 0) aString
    else aString + " " + aRepeatedFunction(aString, n - 1)
  }
  println(aRepeatedFunction("yup", 5))

  @tailrec
  def aRecFunc2(stringInput: String, nTimes: Int, result: String = ""): String = {
    if (nTimes == 0) result
    else aRecFunc2(stringInput, nTimes - 1, stringInput + " " + result)
  }
  println(aRecFunc2("test", 5))

  // WHEN YOU NEED LOOPS USE RECURSION
  // Compiler can't figure out return types for recursive functions.


  def aFunctionWithSideEffects(aString: String): Unit = println(aString)
  aFunctionWithSideEffects("hellooo")


  // can define functions within a code block
  def aBigFunction(n: Int): Int = {
    def aSmallerFunction(a: Int, b: Int) : Int = a + b
    aSmallerFunction(n, n - 1)
  }
  println(aBigFunction(5))

}
