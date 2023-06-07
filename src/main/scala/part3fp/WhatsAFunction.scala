package part3fp

object WhatsAFunction extends App {

  // First class citizens - work with functions like plain values

  // Can pass one or more functions as another function's / method's parameters
  // Can use functions as values
  // Can replace a value with a function
  // Can assign a function literal to a variable. We can pass one or more functions as another function's parameters

  // all functions are instances of the classes Function1, Function2 .... Function22



  // An example of an instance of a function!
  // Scala supports these function types out of the box: Function1, Function2 .... Function22
  val newFunc = new MyFunction2[Int, String] {
    override def apply(anInt: Int): String = anInt.toString
  }
  println(newFunc(20))



  val stringToIntConverter1 = new Function1[String, Int] {
    override def apply(aString: String): Int = aString.toInt
  }
  println(stringToIntConverter1("5") - 2)

  val stringToIntConverter2: String => Int = (x: String) => x.toInt
  println(stringToIntConverter2("5") + 9999)

  // Function types - Function2[A, B, C] === ((A, B) => C)
  // Ie: takes in params of type A & B, and has the return type C.

  // ALL SCALA FUNCTIONS ARE OBJECTS
  // another way of phrasing it - scala functions are instances of classes function1[a, b], function2[a, b, c], function3[a, b, c, d].... etc.

}

trait MyFunction2[A, B] {
  def apply(element: A) : B
}
