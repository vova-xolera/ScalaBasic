package lectures.week1basics

import scala.annotation.tailrec

object weekTasks extends App{
  val string = "I   like Scala"
  val listString = string.split(" ")
  println(string.split(" ").filter(_.nonEmpty).reverse.mkString(" "))
  println(reversWord(listString))
  def reversWord(words: Array[String]): String = {
    @tailrec
    def loop(words: Array[String], acc: String ="", leight: Int = words.length): String = {
      if (leight == 0) acc
      else if (words.apply(leight - 1).equals(" ") || words.apply(leight-1).equals("")) loop(words, acc, leight - 1)
      else {
          loop(words, acc = acc + " " + words.apply(leight - 1), leight - 1)
      }
    }

    loop(words)
  }
}
