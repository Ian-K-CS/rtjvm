package lectures.part2oop
// any definitions written in this file will be part of lectures.part2oop

import playground.{Cinderella => Princess, PrinceCharming}


// any definitions written in this file will be part of lectures.part2oop

object PackagingAndImports extends App {

  // package - bunch of definitions grouped together

  // package members within a package are visible by using their simple name
  // otherwise you have to import packages / classes in
  val princess = new Princess // aliasing! handy for name conflicts on imports

  // fully qualified path name
  val anotherPrincess = new playground.Cinderella


  // packages are in hierarchy and given in dot notation
  // matches folder structure


  // package object - see 'package' file - very rarely used.
  sayHello()
  print(speed_of_light)


  // imports
  val prince = new PrinceCharming

}
