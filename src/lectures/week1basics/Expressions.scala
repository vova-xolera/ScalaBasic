package lectures.week1basics

object Expressions extends App {
  val aVal = 1 + 2 * 3
  val aNumber = if (("string".length == 6 & 1 < 2) & ('1' +: "23" :+ '4').toInt == 1234)  24 else 123
  println(aNumber)
  val someVal = print("It is just a value")
  println(someVal)
  val aCodeBlock = {
    val someVal = 1
    val y = 2

    if (someVal + y > 1) true else false

    "String to return"
  }


  println(aCodeBlock) // выводит "String to return"

  val someValue = {
    1 < 0
    2 == 5
    4 < 9
  }

  val someCodeBlock = {
    if (someValue) 1 else 0
    0
  }

  println(someCodeBlock)

  val someV = { 1 < 5; "Some String"; 12 }
  println(someV)
}
