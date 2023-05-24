package lectures.part1basics

object CallByNameVsCallByValue extends App {

  def calledByValue(x: Long): Unit = {
    println(s"by value $x")
    println(s"by value $x")
  }

  // The => in the param tells the compiler that the parameter x will be 'called by name'
  def calledByName(x: => Long): Unit = {
    println(s"by name $x")
    println(s"by name $x")
  }

  calledByValue(System.nanoTime())
  calledByName(System.nanoTime())

  // call by value - param is always evaluated before methods calls
  // call by name - param evaluated every time they are referred to within a method body


  def infinite(): Int = 1 + infinite()
  def printFirst(x: Int, y: => Int): Unit = println(x)

//  printFirst(infinite(), 34) // will get stuck in a loop because the param x in printFirst is call by value
  printFirst(23, infinite()) // will NEVER get stuck in a loop because the param y in printFirst is call by name and is never called within the printFirst body
}
