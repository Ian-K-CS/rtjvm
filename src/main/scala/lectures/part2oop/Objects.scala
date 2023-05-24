package lectures.part2oop

import lectures.part2oop.Objects.Person.EYES

object Objects extends App {

  // can access companion objects members
  class Person(val name: String) {
    // instance level functionality
  }

  // companion object to companion Person Class
  object Person {
    // class level functionality
    val EYES = 2
    def canFly: Boolean = false

    // factory method - creating a new Person
    def apply(mother: Person, father: Person): Person = new Person("Bobbie")
  }


  println(Person.EYES)
  println(Person.canFly)

  // Scala objects are singleton instances (theres only one of them)
  // the type of objects are <object name>.type

  val mary = new Person("Mary")
  val john = new Person("John")
  println(mary == john)

  val person1 = Person
  val person2 = Person
  println(person1 == person2)

  val bobbie = Person(mary, john)
  println(bobbie)

  // Scala Applications = Scala object with
  // def main(args: Array[String]): Unit


}
