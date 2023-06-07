trait Trait1[A] {
  def test(testInput: A): Boolean
}

val anonClass1 = new Trait1[Int] {
  override def test(testInput: Int): Boolean = testInput % 2 == 0
}

val anonClass2 = new Trait1[String] {
  override def test(testInput: String): Boolean = testInput.isEmpty
}

println(anonClass1.test(4))
println(anonClass2.test("hi"))
println(anonClass2.test(""))



trait Trait2 {
  def stringSomething(name: String): String
}

class Hello extends Trait2 {
  override def stringSomething(name: String): String = s"Hi $name"
}
class Goodbye extends Trait2 {
  override def stringSomething(name: String): String = s"Goodbye, $name"
}
class Scare extends Trait2 {
  override def stringSomething(name: String): String = s"Boo!, scared you $name"
}

def aPrinter(greeting: Trait2, name: String): Unit = {
  println(greeting.stringSomething(name))
}

val helloGreeting = new Hello
val goodbyeGreeting = new Goodbye
val scareGreeting = new Scare

aPrinter(helloGreeting, "Dave")
aPrinter(goodbyeGreeting, "James")
aPrinter(scareGreeting, "Amy")