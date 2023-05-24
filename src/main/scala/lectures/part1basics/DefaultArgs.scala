package lectures.part1basics

import scala.annotation.tailrec

object DefaultArgs extends App {

  @tailrec
  def factorialTR(n: Int, accumulator: Int = 1): Int = {
    if (n == 0) accumulator
    else factorialTR(n - 1, accumulator * n)
  }
  println(factorialTR(4))


  def savePicture(format: String = "jpg", width: Int = 1920, height: Int = 1080): Unit = println("saving picture")

  // here we are naming the arguments because of the defaults in the method
  savePicture(width = 800, height = 600)
  savePicture(width = 800, height = 600, format = "bmp")

}
