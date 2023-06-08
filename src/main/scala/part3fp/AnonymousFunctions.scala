package part3fp

object AnonymousFunctions extends App {

  // oop way of defining an anonymous function and instantiating it on the spot
  val oopDoubler = new Function1[Int, Int] {
    override def apply(x: Int): Int = x * 2
  }


  // this is an ANONYMOUS FUNCTION (lambda)
  // this basically instantiates a Function1[A, B] with the override def #apply
  val anonFunctionDoubler = (x: Int) => x * 2
  val anonFunctionDoublerWithType: Int => Int = (x: Int) => x * 2


  // Syntax Rules - Anonymous Functions
  // as we've defined the Types - we can also write in shorter hand. If we remove the Types, the compiler can't infer & complains
  val anonFunctionDoublerShortHand: Int => Int = x => x * 2


  // multiple params in a anon function / lambda
  val anonFunctionMultipleParams: (Int, Int) => String = (x, y) => (x * y).toString


  // mo params
  val anonFunctionNoParams: () => Int = () => 4


  // ANON FUNCTIONS / LAMBDAS MUST BE CALLED WITH PARENTHESIS!
  println(anonFunctionNoParams) // prints the memory location of the instance of the function
  println(anonFunctionNoParams()) // prints the value of the function


  // curly braces with anon functions / lambdas
  val stringToInt = { (str: String) =>
    str.toInt
  }


  // using underscores - highly contextual - make sure Types are explicitly written
  val incrementer1: Int => Int = x => x + 1
  // using underscore - just like you can use in #map!! Eg: someObject.map(x = x + 1) ....... someObject.map(_ + 1)
  val incrementer2: Int => Int = _ + 1
  // also works with 2+ params, each underscore takes the params in order
  val adder: (Int, Int) => Int = _ + _






}
