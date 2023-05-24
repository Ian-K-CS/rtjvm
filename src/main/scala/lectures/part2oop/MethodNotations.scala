package lectures.part2oop

import scala.language.postfixOps

object MethodNotations extends App {

  class Person(val name: String, faveMovie: String) {
    def likes(movie: String): Boolean =  movie == faveMovie
    def hangOutWith(person: Person): String = s"$name is hanging out with ${person.name}"
    def unary_! : String = s"$name what the ?!?"
    def isAlive: Boolean = true
    def apply(): String = s"Hi, my name is $name and I like $faveMovie"
  }

  val mary = new Person("Mary", "inception")
  println(mary.likes("inception"))
  println(mary likes "inception") // infix notation. Only works with methods with one param.

  val james = new Person("James", "departed")
  println(mary.hangOutWith(james))
  println(mary hangOutWith james)

  println(1 + 2) // this is infix notation
  println(1.+(2))


  // prefix notion - all about unary operators
  val x = -1 // equivalent with 1.unary_-
  val y = 1.unary_-

  // unary_ prefix only works with - + ~ !
  println(!mary)
  println(mary.unary_!)


  // postfix notation
  // methods without params can be used in postfix notation
  println(mary.isAlive)
  println(mary isAlive)

  // apply
  println(mary.apply())
  print(mary()) // equivalent

}
