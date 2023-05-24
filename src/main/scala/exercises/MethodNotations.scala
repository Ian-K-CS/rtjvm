package exercises

import scala.language.postfixOps

object MethodNotations extends App {

  /*
  QUESTIONS
    1. Overload + operator in Person class. Receives nick name String => new Person with a nickname
      - eg: mary + "the rockstar" => new Person "Mary (the rockstar)"

    2. Add age to Person w/ default 0. add unary + operator => new Person with age + 1
      - eg: +mary => mary with the age incremented

    3. Add learns method to Person class w/ param of what is being learned. => "Mary learns Scala"
       Add a learnScala method, calls leans method with "Scala".
       use it in postfix notation

    4. Overload apply method
       mary.apply(2) => "Mary watched inception 2 times"
  */



  // ANSWERS

  class Person(val name: String, faveMovie: String, val age: Int = 0) {
    def likes(movie: String): Boolean =  movie == faveMovie
    def +(person: Person): String = s"$name is hanging out with ${person.name}"
    // 1.
    def +(nickName: String): String = s"$name ($nickName)"

    def unary_! : String = s"$name what the ?!?"
    // 2.
    def unary_+ : Person = new Person(name, faveMovie, age + 1)

    def isAlive: Boolean = true
    // 3.
    def learns(learning: String): String = s"$name is learning $learning"
    def leansScala: String = learns("Scala")

    def apply(): String = s"Hi, my name is $name and I like $faveMovie"
    // 4.
    def apply(x: Int): String = s"$name watched $faveMovie $x times"
  }
  val mary = new Person("Mary", "Inception", 56)
  println(mary + "the rockstar")
  println((+mary).age)
  println(mary leansScala)
  println(mary(5))

}
