package lectures.part2oop

object InheritanceAndTraits extends App {

  // super class
  // single class inheritance
  class Animal {
    private val x: Int = 34 // inheritance doesn't share private members
    protected val y: Int = 456 // protected - only available to current class and any that extend it. Not callable on any instances
    val creatureType: String = "Wild"
    val numberOfLegs: Int = 2

    def eat(): Unit = println("nomnomnom")

  }

  // sub class
  class Cat extends Animal {
    val protectedTest: Unit = println(y)

    def crunch(): Unit = {
      eat()
      println("crunch crunch")
    }

  }

  val cat = new Cat
  cat.crunch()



  // constructors
  class Person(name: String, age: Int) {
    def this(name: String) = this(name, 0)
  }

  class Adult(name: String, age: Int, idCard: String) extends Person(name, age) // if inheriting from a class, the compiler requires the params of the super class= to construct it.
  class AnotherAdult(name: String, age: Int, idCard: String) extends Person(name) // compiler will pick up auxiliary class constructor



  // overriding
  class Dog(override val numberOfLegs: Int) extends Animal { // we can override directly from the constructor as well!
    override def eat(): Unit = {
      super.eat() // calls the super class method. Not #eat in the sub class Dog. So we get the value "nomnomnom"
      println("gobble gobble")
    }
    override val creatureType: String = "domestic"

  }
  val dog = new Dog(4)
  dog.eat()
  println(dog.creatureType)
  println(dog.numberOfLegs)




  // type substitution (broadly speaking - polymorphism)
  // We use the super class Type Animal, and because Dog class extends this, we can define a new Dog instance.
  val unknownAnimal: Animal = new Dog(4)




  // super
  // when you want to reference a method/val from the parent class - this is defined on line 46 in Dog class
  dog.eat()




  // preventing overrides
  // Final keyword - for methods/vals - stops sub classes overriding it.
  //               - for classes - stops entire class from being inherited
  // Sealed keyword - softer than Final. Allows extension only within the file

}
