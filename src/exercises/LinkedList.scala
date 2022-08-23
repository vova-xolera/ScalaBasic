package exercises

object LinkedList extends App {
  abstract class LogList {
    def last: String
    def previous: LogList
    def isEmpty: Boolean
    def all: String
    def add(msg:String): LogList
  }
  class Log(head: String, tail: LogList) extends LogList{
    def add(msg: String): LogList = new Log(msg, this)
    override def last: String = head
    override def previous: LogList = tail
    override def isEmpty: Boolean = tail.equals(Empty)
    override def all = head + " " + tail.all
  }

  object Empty extends LogList {
    def add(msg: String): LogList = new Log(msg, Empty)
    override def last: String = throw new NoSuchElementException
    override def previous: LogList = throw new NoSuchElementException
    override def isEmpty: Boolean = true
    override def all: String = ""
  }

  println(new Log("m7",(new Log("m44",(new Log("m1", new Log("m2", new Log("m3", Empty))))))).all)

  val list = new Log("a", new Log("b", Empty))
  val newList = list.add("c")
  println(newList.all)
}
