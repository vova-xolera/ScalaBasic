package lectures.week2oop

object SyntacticSugar extends App{
  class Course(title: String, instructor: String)
  def course = new Course("Scala", "Bob")
}
