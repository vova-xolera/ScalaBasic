package exercises

object GenericList extends App {
  abstract class LogList[+A] {
    def last: Any
    def previous: LogList[A]
    def isEmpty: Boolean
    def all: String
    def add(msg:Any): LogList[Any]
  }
  class Log[+A](head: A, tail: LogList[A]) extends LogList[A]{
    def add(msg:Any): Log[Any] = new Log(msg, tail)
    override def last: A = head
    override def previous: LogList[A] = tail
    override def isEmpty: Boolean = tail.equals(Empty)
    override def all: String = head + " " + tail.all
  }

  object Empty extends LogList {
    def add(msg: Any): LogList[Any] = new Log(msg, Empty)
    override def last: Any = throw new NoSuchElementException
    override def previous: LogList[Nothing] = throw new NoSuchElementException
    override def isEmpty: Boolean = true
    override def all: String = ""
  }

  println(new Log(1,(new Log(2,(new Log(3, new Log(4, new Log(5, Empty))))))).all)

}
