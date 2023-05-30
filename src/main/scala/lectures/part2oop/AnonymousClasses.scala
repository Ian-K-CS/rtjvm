package lectures.part2oop

object AnonymousClasses extends App {

  trait Animal {
    def eat(): Unit
  }


  // anonymous class
  val funnyAnimal: Animal = new Animal {
    override def eat(): Unit = println("nomnomnom")
  }
  println(funnyAnimal.getClass)


  // The above is the same as - This is what happens when you instantiate an anonymous class as above. Ie, instantiating a trait or abstract class.
  class AnonymousClasses$$anon$1 extends Animal {
    override def eat(): Unit = println("nomnomnom")
  }
  val anotherFunnyAnimal: Animal = new AnonymousClasses$$anon$1
  println(anotherFunnyAnimal.getClass)


  class Person(name: String) {
    def sayHi(): Unit = println(s"Hi, my name is $name, how can I help?")
  }

  val Jim = new Person("Jim") {
    override def sayHi(): Unit = println(s"Hi, my name is Jim, how can I help?")
  }

}
