package lectures.part2oop

object CaseClasses extends App {

  // case class - light weight data structure
  case class Person(name: String, age: Int)


  // 1. class params are fields - no need to add a val infront of the param
  val jim = Person("Jim", 34)
  println(jim.name)


  // 2. a Sensible .toString for easier debugging - string representation of the object (.mkString looks at the value and turns it into a string).
  println(jim.toString)
  // it automatically delegates to the .toString method by calling the instance
  // println(instance) = println(instance.toString) - syntactic sugar
  println(jim)


  // 3. equals and hasCode implemented out of the box
  // equality checks the contents is the same, NOT that they are the same instance.
  val jim2 = Person("Jim", 34)
  println(jim == jim2) // true - name and age values are both the same.


  // 4. Case classes have copy methods already.
  // These create a new instance of the case class copied (you can pass in specific case class params to change the values of the new copy)
  val jim3 = jim2.copy()
  println(jim3)

  val chloe = jim2.copy(name = "Chloe", age = 65)
  println(chloe)


  // 5. Case classes have companion objects
  val thePerson = Person // this calls the companion object
  val mary = Person("Mary", 23) // delegates to the apply method in the companion object


  // 6. Case classes are serializable - useful for distributed systems


  // 7. Case classes have extractor patterns
  // case classes can be used in pattern matching


  // Case object - same properties as case classes. Useful when you have no params.
  case object UnitedKingdom {
    def name: String = "The UK of GB and NI"
  }

}
