package lectures.part1basics

object Expressions extends App {

  val x: Int = 1 + 2 // 1 + 2 is an expression. Expressions evaluate to a value and have a Type
  println(x)

  println(2 + 3 * 4)
  // math operators + - / *

  println(1 == x)
  // equality operators == != > >= < <=

  println(!(1 == x))
  // logical operators ! && ||

  var aVariable: Int = 2
  aVariable += 3 // also works with -= /= *= ...... these are all side effects
  println(aVariable)


  // instructions vs expressions
  // instruction (statement) - something you tell the computer to do (imperative programming). Think of this as: "computer do something"
  // expression - something that has a value and/or a Type (declarative programming). Think of it as: "give me the value of something"


  // If expression
  val aCondition: Boolean = true
  val aConditionValue = if(aCondition) 5 else 3
  println(aConditionValue)
  println(if(aCondition) 5 else 3)


  var i = 0
  val aWhileLoop: Unit = while (i < 10) {
    println("hey")
    i += 1
  }

  // NEVER write loops (side effect, you can see above the type is Unit) - loops are specific to imperative programming.

  // everything in scala is an expression (except val / method / class / package declaration, for example)

  val aWeirdValue = aVariable = 3 // Unit === void
  println(aWeirdValue) // () is the value of Unit

  // side effects in Scala return Unit Type. Eg - println(), while loops, reassigning variables.



  // Code blocks
  val aCodeBlock: String = {
    val y = 2
    val z = y + 1

    if (z > 2) "hello" else "goodbye"
  }

  // code blocks are expressions
  // value of code block is the last expression evaluated
}
