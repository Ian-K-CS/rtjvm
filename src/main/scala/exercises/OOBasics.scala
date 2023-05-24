package exercises

object OOBasics extends App {

  val newWriter = new Writer("Dave", "Smith", 1975)
  println(newWriter.fullName)
  val anotherWriter = new Writer("Alex", "Smith", 1935)

  val newNovel = new Novel("a Book", 2002, newWriter)
  println(newNovel.authorAge)
  println(newNovel.isWrittenBy(newWriter))
  println(newNovel.isWrittenBy(anotherWriter))
  println(newNovel.copy(2001))

  val newCounter = new Counter(5)
  println(newCounter)
  println(newCounter.increment.count)
  println(newCounter.increment(4).count)
  println(newCounter.decrement.count)
  println(newCounter.decrement(10).count)

}

/*
  QUESTIONS

  1. Implement Writer and Novel
  Writer: first name, surname, year of birth
    - method fullName
  Novel: name, year of release, author
    - method author age - age of author at year of release.
    - method isWrittenBy(author)
    - method copy(new year of release) = new instance of novel with new year of release.

  2. Implement Counter
    - receives int
    - method current count
    - method to increment/decrement the counter by 1 (will return new counter)
    - overload inc/dec to receive a param, amount by which you inc/dec. Returns new Counter
*/

// ANSWERS

// 1.
class Writer(firstName: String, surname: String, val yearOfBirth: Int) {

  def fullName: String = firstName + " " + surname

}

class Novel(name: String, yearOfRelease: Int, val author: Writer) {

  def authorAge: Int = yearOfRelease - author.yearOfBirth

  def isWrittenBy(author: Writer): Boolean = author.fullName == this.author.fullName
  def isWrittenBy2(author: Writer): Boolean = author == this.author // checks the object is the same - unlike case classes which checks the contents is the same, not the obj,

  def copy(newYearOfRelease: Int): Novel = new Novel(name, newYearOfRelease, author)

}

class Counter(val count: Int) {

  def increment: Counter = new Counter(count + 1) // immutability - creating a new object, not adjusting state of current obj instance.
  def increment(x: Int): Counter = new Counter(count + x)

  def decrement: Counter = new Counter(count - 1)
  def decrement(x: Int): Counter = new Counter(count - x)

}
