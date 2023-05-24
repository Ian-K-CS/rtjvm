package lectures.part2oop

object OOBasics extends App {

  val person = new Person("John", 26) // instantiating a new Person object from the Person class
  println(person)
  println(person.age)
  println(person.x)
  println(person.greet("Dan"))

  val newPerson = new Person("Alex")
  println(newPerson.age)
  val newPerson2 = new Person()
  println(newPerson2.name)

}

// class constructor. Every instance of Person, must include a name and age
class Person(val name: String, val age: Int = 0) {
  // class body
  val x = 2
  println(1 + 3)

  //method
  def greet(name: String): Unit = println(s"${this.name} says: Hi, $name") // 'this' accesses the objects own methods & fields

  // overloading - same method name, different method signatures (different params)
  def greet(): Unit = println(s"Hi, I am $name") // Its implied the $name refers to $this.name.

  // Auxiliary constructors
  def this(name: String) = this(name, 3) // calls primary constructor
  def this() = this("john doe")
}

// class params are NOT FIELDS. You need to add the keyword val/var in order to make it a field/member of the class(so you can use dot notation and call it)
