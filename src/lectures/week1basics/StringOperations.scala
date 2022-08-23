package lectures.week1basics

object StringOperations extends App {

  val aString: String = "Scala course"

  println(aString.length) // выводит 13
  println(aString.charAt(1)) // выводит e
  println(aString.substring(1, 2)) // выводит He
  println(aString.split(" ").toList) // выводит List(Hello,, world!)
  println(aString.startsWith("He")) // выводит true
  println(aString.replace("!", ".")) // выводит Hello, world.
  println(aString.toLowerCase) // выводит hello, world!
  println(aString.toUpperCase) // выводит HELLO, WORLD!
  println("abcd".reverse) // выводит dcba
  println(aString.take(0)) // выводит ab

  println('1' +: "42" ) // выводит 1423
  println('a' +: "bc" :+ 'd') // abcd
  println("a" ++: "bc" :+ "d") // abcd

  println((1 +: List(2, 3)).length) // List(1, 2, 3)
  println(List(1, 2) ++ List(3, 4)) // List(1, 2, 3, 4)
  println(List(1, 2) +: List(3, 4)) //List(List(1, 2), 3, 4)

  val names = "John"

  println(s"Hello,\t$names") // выводит Hello, John

  val name = "John"
  val surname = "Smith"

  println(s"Hello + ${name + " " + surname}") // выводит Hello, JohnSmith

  val link = "https://stepik.org"

  println(link.toUpperCase())

  println(link :+ "/catalog")
}
