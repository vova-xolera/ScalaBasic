package lectures.week3fp

import scala.annotation.tailrec

object FunctionsFP extends App {

  trait Multiplication[A, B] {
    def apply(x: A): B
  }

  val res = new Multiplication[Int, Int] {
    override def apply(x: Int): Int = x * 2
  }
  println(res(2))

  val res1 = new Function1[Int, Int] {
    override def apply(x: Int): Int = x * 2
  }

  val product = new ((Int, Int) => Int) {
    override def apply(x: Int, y: Int): Int = x * y
  }

  println(product(3, 4)) // выводит 12

  val strlen: String => Int = x => x.length

  @tailrec
  def nTimes(f: Int => Int, x: Int, n: Int): Int = {
    if (n <= 0) x
    else nTimes(f, f(x), n - 1)
  }

  def someFunc: Int => Function1[Int, Int] = new Function1[Int, Function1[Int, Int]] {
    override def apply(x: Int): Function1[Int, Int] = new Function1[Int, Int] {
      override def apply(y: Int): Int = x + y
    }
  }

  val r = someFunc(1)

  println(r(3) + 500)

  val chatbot1: PartialFunction[String, String] = {
    case "hello" => "Hi, I'm Bot"
    case "bye" => "Bye-bye"
    case "what's up" => "sup-sup"
  }
  val chatbot = chatbot1.lift

  println(chatbot("hello"))

}
