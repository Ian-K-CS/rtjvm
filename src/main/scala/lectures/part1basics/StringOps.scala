package lectures.part1basics

object StringOps extends App {

  val str: String = "I am working with Scala strings"

  println(str.charAt(2))
  println(str.substring(5))
  println(str.substring(5, 12))
  println(str.split(" ").mkString)
  println(str.split(" ").toList)
  println(str.startsWith("Hello"))
  println(str.replace(" ", "-"))
  println(str.toLowerCase)
  println(str.toUpperCase)
  println(str.length)

  val aNumberString = "45"
  val aNumberInt = aNumberString.toInt

  println('a' +: aNumberString) // prepending

  println(str.reverse)
  println(str.take(4))


  //scala-specific - string interpolation

  // S-interpolators
  val name = "David"
  val age = 12
  val greeting = s"Hi, $name you are $age years old"
  println(greeting)

  val anotherGreeting = s"Hi, $name you will be ${age + 2} years old in another 2 years"
  println(anotherGreeting)

  // F-interpolators (acts like S-interpolation plus can also receive string formatting - printf)
  val speed = 1.2f
  val myth = f"$name can eat $speed%2.2f burgers per minute" // the format forces two decimal space precision
  println(myth)

  // raw-interpolator (similar to S-interpolator
  println(raw"This is a \n newline")
  val escaped = "This is a \n newline"
  println(raw"$escaped")

}
