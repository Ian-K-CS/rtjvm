package lectures.part2oop

object AbstractDataTypes extends App {

  // abstract members - not implemented. Classes that contain these are called abstract classes.
  // abstract classes can't be instantiated. They are made to be extended where the subclass defines the implementation.
  abstract class Animal {
    val creatureType: String = "wild"
    def eat(): Unit
  }

  class Dog extends Animal {
    // You don't NEED the override keyword to override members, the compiler just knows. However, it does make things a lot clearer to include the keyword.
    override val creatureType: String = "K9"
    override def eat(): Unit = println("crunch crunch")
  }



  // traits - not limited to mixing in one trait, unlike inheriting from only one class.
  trait Carnivore {
    def eat(animal: Animal): Unit
  }

  trait ColdBloded

  class Crocodile extends Animal with Carnivore with ColdBloded {
    override val creatureType: String = "croc" // inherited from Animal trait

    override def eat(): Unit = println("nomnomnom") // inherited from Animal trait

    override def eat(animal: Animal): Unit = println(s"Im a $creatureType and I'm eating a ${animal.creatureType}") // inherited from Carnivore trait
  }

  val dog = new Dog
  val croc = new Crocodile
  croc.eat(dog)


  // traits vs abstract classes
  // 1. Both traits and abstract classes can have abstract and concrete members.
  // 2. Traits don't have constructor params.
  // 3. Multiple traits can be inherited by the same class.
  // 4. Traits = behaviour, abstract class = thing

}
