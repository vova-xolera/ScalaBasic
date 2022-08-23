package lectures.week1basics

import scala.annotation.tailrec

object Recursion extends App {
  def factorial(n: Int): Int = {
    if (n <= 0) 1
    else {
      println(s"Имеем число $n, для которого считаем факториал ${n-1}")
      var res = n * factorial(n-1)
      println(s"Вычислили факториал $n")

      res
    }
  }

  factorial(3)

  def factorialWithTailRecursion(n: Int): Long = {
    @tailrec
    def loop(x: Int, accumulator: Long): Long = {
      if (x <= 1) accumulator
      else loop(x-1, x*accumulator)
    }

    loop(n, 1)
  }
  println(factorialWithTailRecursion(20))

  def repeatWord(word: String, n: Int): String = {
    @tailrec
    def loop(i: Int, acc: String = word): String = {
      if (i <= 1) acc
      else loop(i - 1, s"$word $acc")
    }

    loop(n)
  }
  println(repeatWord("what's up?!", 5))

  def powerOfTwo(m: Int): BigInt = {
    @tailrec
    def go(n: Int, acc: BigInt = 1): BigInt = {
      if (n < 1) acc
      else go(n - 1, 2 * acc)
    }

    go(m)
  }

  println(powerOfTwo(100))

  def multiply(x: Int, y: Int = 1, n: Int = 1): String = {
    @tailrec
    def go(x: Int, y: Int, n1: Int, acc1: BigInt = x): BigInt = {
      if (n1 <= 0) acc1
      else go(x, y, n1 - 1, acc1 = acc1 + y)
    }
    val res = go(x, y, n).toInt
    @tailrec
    def loop (res: Int, out: Int = res, acc: String = ""): String = {
      if (res <= 0) {
        println(acc + "is the result")
        acc + "is the result"
      }

      else loop(res / 10, out, acc + out + " ")
    }
    loop(res)
  }

  println(multiply(5, 2, 2))
}
