package lectures.part1basics

object Functions extends App {

  def aFunction(a: String, b: Int): String = {
    a  + " " + b
  }

  println(aFunction("hello", 3))

  def aParameterlessFunction(): Int = 42
  println(aParameterlessFunction())
  println(aParameterlessFunction)

  def aRepeatedFunction(aString: String, n: Int): String = {
    if (n == 0) aString
    else aString + " " + aRepeatedFunction(aString, n - 1)
  }

  println(aRepeatedFunction("yup", 5))

  // WHEN YOU NEED LOOPS, USE RECURSION.


  def aFunctionWithSideEffects(aString: String): Unit = println(aString)

  def aBigFunction(n: Int): Int = {
    def aSmallerFunction(a: Int, b: Int) : Int = a + b

    aSmallerFunction(n, n - 1)
  }
  println(aBigFunction(5))


}
