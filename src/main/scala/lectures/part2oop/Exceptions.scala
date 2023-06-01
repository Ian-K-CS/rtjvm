package lectures.part2oop

object Exceptions extends App {
  val x: String = null
//  println(x.length)
//  this ^^^ will crash with a null pointer exceptions


  // 1. throwing exceptions
//  val aWeirdValue: String = throw new NullPointerException() // an expression that throws an exception. As theres nothing to catch it, the program crashes.
  // the Type of an exception is Nothing. Nothing is a valid substitute for any other Type

  // throwable classes extend the throwable class.
  // exception and error the major throwable subtypes.

  // exceptions denote something went wrong with your program
  // errors went wrong with the system.


  // 2. How to catch exceptions
  def getInt(withExceptions: Boolean): Int = {
    if (withExceptions) throw new RuntimeException("No Int for you!")
    else 42
  }

  // potentialFail has multiple different Type outcomes. So defaults to anyVal as a type in this example.
  val potentialFail = try {
    // code that might fail/throw
    getInt(true)
    } catch {
    // in here we try to match what type of exception might be thrown
    case e: RuntimeException => println("caught a Runtime exception")
  } finally {
    // code that will get executed NO MATTER WHAT
    // finally is optional.
    // does not influence the return type of this expression
    // use finally for side effects - logging, etc.
    println("finally")
  }

  // 3. Define your own exceptions
  class MyException extends Exception
  val exception = new MyException

  throw exception

}
