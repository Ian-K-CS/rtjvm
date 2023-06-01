package exercises

/*
  QUESTIONS

  1. Crash your program with an OutOfMemoryError
  2. Crash with a StackOverFlowError
  3. Define a PocketCalculator
    - adds(x,y)
    - multiply(x,y)
    - divide(x,y)
    - subtract(x,y)

    Throw a custom exception if something wrong happens.
    - OverflowException if add(x,y) exceeds Int.MAX_VALUE
    - UnderflowException if subtract(x,y) exceeds Int.MIN_VALUE
    - MathCalculatorException for division by 0

 */

object Exceptions extends App {

  // 1.
//  val array = Array.ofDim(Int.MaxValue)


  // 2.
  def infiniteLoop(n: Int): Int = {
     n + infiniteLoop(n + 1)
  }
//  infiniteLoop(1)


  // 3.
  sealed trait Calculator {
    def add(x: Int, y: Int): Int
    def multiply(x: Int, y: Int): Int
    def divide(x: Int, y: Int): Int
    def subtract(x: Int, y: Int): Int
  }

  class OverflowException extends Exception
  class UnderflowException extends Exception
  class MathCalculatorException extends Exception

  case object PocketCalculator extends Calculator {

    override def add(x: Int, y: Int): Int = {
      if (x > 0 && y > 0 && x.toLong + y.toLong > Int.MaxValue) throw new OverflowException
      else if (x < 0 && y < 0 && x.toLong + y.toLong < Int.MinValue) throw new UnderflowException
      else x + y
    }

    override def multiply(x: Int, y: Int): Int = {
      if (x > 0 && y > 0 && x.toLong * y.toLong > Int.MaxValue) throw new OverflowException
      else if (x < 0 && y < 0 && x.toLong * y.toLong > Int.MaxValue) throw new OverflowException
      else if ((x > 0 && y < 0) || (x < 0 && y > 0) && (x.toLong * y.toLong) < Int.MinValue) throw new UnderflowException
      else x * y
    }

    override def subtract(x: Int, y: Int): Int = {
      if (x < 0 && y > 0 && x.toLong - y.toLong < Int.MinValue) throw new UnderflowException
      else if (x > 0 && y < 0 && x.toLong - y.toLong > Int.MaxValue) throw new OverflowException
      else x - y
    }

    override def divide(x: Int, y: Int): Int = {
      if (y == 0) throw new MathCalculatorException
      else x / y
    }
  }

  val pockCal = PocketCalculator
//  pockCal.add(2147483647, 1)
//  println(pockCal.add(-2147483648, -1))

//  pockCal.multiply(2147483647, 2)
//  pockCal.multiply(-2147483647, -2)
//  pockCal.multiply(2147483647, -2)
//  pockCal.multiply(-2147483647, 2)

//  pockCal.subtract(-2147483648, 1)
//  pockCal.subtract(2147483647, -1)

//  println(pockCal.divide(1, 0))

}
