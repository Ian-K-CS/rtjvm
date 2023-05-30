package lectures.part2oop

object Generics extends App {

  class MyList[A] {
    // [A] is a type parameter - can be use inside the class
    def print(a: A): Unit = println(a)
    // can add methods with any type param, doesn't have to be connected to class constructor type param
    def aMethod[Y](input: Y)(): Unit = println(input)
  }

  val listOfInteger = new MyList[Int]
  val listOfString = new MyList[String]



  // can have multiple type parameters
  class MyMap[Key, Value]

  val aNewMap = new MyMap[String, Double]



  // type params also work on traits - this flows down into subclasses
  trait AnotherList[A]




  // generic methods
  // the type param isn't connected to the class MyList's type param
  object MyList {
    def empty[T]: MyList[T] = new MyList[T]
  }
  // how we would use a generic method
  val emptyListOfIntegers = MyList.empty[Int]





  // variance problem
  // QUESTION - if Cat extends Animal - does a List[Cat] also extend List[Animal] ?
  class Animal
  class Cat extends Animal
  class Dog extends Animal



  // 1. Yes - List[Cat] extends List[Animal] = COVARIANCE
  // IE, it works like normal type substitution with traits and their subclasses and being able to substitute: val animal: Animal = new Cat
  class CovariantList[+A]
  val covariantAnimalList: CovariantList[Animal] = new CovariantList[Cat]
  // QUESTION - If you declared a covariant list of Animal (CovariantList[Animal]
  // can you add/include any of the subclasses to it? Bearing in mind this will pollute the List as we are adding multiple different types?
  // This is solved later on


  // 2. No List[Animal] and list[Cat] are two separate things = INVARIANT - no type substitution allowed !
  class InvariantList[A]
  //  val invariantAnimalList: InvariantList[Animal] = new InvariantList[Cat] // compiler doesn't like this.
  val workingInvariantList:  InvariantList[Animal] = new InvariantList[Animal] // this works


  // 3. Contravariance - opposite of covariance
  class ContravariantList[-A]
  val contravariantList: ContravariantList[Cat] = new ContravariantList[Animal]

  class Trainer[-A]
  val trainer: Trainer[Cat] = new Trainer[Animal]





  // BOUNDED TYPES- allow use of generic class for certain types that are either a subclass of a different type or a superclass of a different type

  // UPPER BOUNDED TYPE
  // class Cage has a type param that can ONLY be a subtypes of Animal (Dog or Cat in this example).
  // Upper Bound is also inclusive, which means Animal type is ok too
  class Cage[A <: Animal](animal: A)
  val cage1 = new Cage[Animal](new Dog)
  val cage2 = new Cage[Animal](new Cat)
  val cage3 = new Cage[Animal](new Animal)

  class Car
  //  val aNewCar = new Cage(new Car) // compiler doesn't like this as Car is not a subtype of Animal



  // LOWER BOUND - solves a covariant collection problem
  // Accepts only a supertype of the type to the right
  class Container[A >: Animal]

  class MyList2[+A] {
//    def add(element: A): MyList2[A] = ??? // this method signature doesn't work!
    // the error that this gives is "covariant type A occurs in contravariant position in type A of value element"
    // this actually refers to a previous question:
    // QUESTION - If you declared a covariant list of Animal (CovariantList[Animal]
    // can you add/include any of the subclasses to it? Bearing in mind this will pollute the List as we are adding multiple different types?

    // correct implementation using lower bound. B is supertype of A
    def correctAdd[B >: A](element: B): MyList[B] = ???
    /*
    Example so far:
    A = Cat
    B = Dog = Animal
    If I add any subtype of Dog to a MyList2[Cat], then it will turn it into a MyList2[Animals], as there are both Cats and Dogs now.
     */
  }

}



