package lectures.week3fp

object Options extends App{
  val someVal = Some(2)
  println(someVal.map(_ * 2).get)

}
