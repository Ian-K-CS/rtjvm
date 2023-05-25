package exercises

/*
QUESTION

  single linked list that holds Ints

  Methods to add:
    head = first element of the list
    tail = remainder of the list
    isEmpty = returns boolean - is the list empty?
    add(int) => new list with element added
    override toString =? a string representation of the list
 */

object BuildingAList extends App {
  val list1 = new NonEmpty(1, new NonEmpty(2, new NonEmpty(3, Empty)))
  println(list1.head)
  val list2 = list1.add(2)
  println(list2.head)
  println(list2.tail.head)
  println(list2.add(4).head)
  println(list2.isEmpty)
  // polymorphic call
  println(list1.toString)
}


abstract class MyList { // 1. sets up whats needed for the constituent parts of the list.
  def head: Int
  def tail: MyList
  def isEmpty: Boolean
  def add(element: Int): MyList

  def printElements: String

  override def toString: String = "[" + printElements + "]"
}

object Empty extends MyList { // 2. Part of a list when the list is Empty, or the tail is eventually empty and theres no additional elements.
  override def head: Int = throw new NoSuchElementException()
  override def tail: MyList = throw new NoSuchElementException()
  override def isEmpty: Boolean = true
  override def add(element: Int): MyList = new NonEmpty(element, Empty)

  override def printElements: String = ""
}

class NonEmpty(h: Int, t: MyList) extends MyList { // 3. Sets up the 'node' of a linked list, head holds the data, and tail holds the pointer to the next node.
  override def head: Int = h
  override def tail: MyList = t
  override def isEmpty: Boolean = false
  override def add(element: Int): MyList = new NonEmpty(element, this)

  override def printElements: String = {
    if (t == Empty) s"$h"
    else h + " " + t.printElements
  }
}
