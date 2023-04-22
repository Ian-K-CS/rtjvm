package lectures.part1basics

object ValuesVariablesTypes extends App {

  val x: Int = 42
  println(x)

  // vals are immutable

  //compiler can infer types

  val aString: String = "hello"
  val anotherString = "goodbye"

  val aBoolean: Boolean = true
  val anotherBoolean: Boolean = false

  val aChar: Char = 'a'
  val anotherChar = '!'

  val anInt: Int = x
  val aShort: Short = 4613
  val aLong: Long = 3434343434545454L
  val aFloat: Float = 2.4f
  val aDouble: Double = 3.14

  // variables
  var aVariable: Int = 4
  aVariable = 5 // side effect
  println(aVariable)

}
