package lectures.week3fp


object Patterns extends App {
  def guard(data: Any, maxLength: Int): String = {
    data match {
      case list: List[Any] if list.size <= maxLength => "Задан список List допустимой длины"
      case list2: List[Any] if list2.size > maxLength => "Длина списка больше максимально допустимого значения"
      case string: String if string.length <= maxLength => "Длина строки не превышает максимально допустимого значения"
      case string2: String if string2.length > maxLength => "Получена строка недопустимой длины"
      case _ => "Что это? Это не строка и не список"
    }
  }

  try {
    object CustomerID {

      def apply(name: String, surname: String) = s"$name $surname"

      def unapply(customerID: String): Option[String] = {
        val stringArray: Array[String] = {
          customerID.split(" ")
        }
        if (stringArray.nonEmpty && stringArray.length > 1) Some(stringArray(0).substring(0, 1) + ". " + stringArray(1).substring(0, 1) + ".") else None
      }
    }

    val line = readLine()
    val stringArray: Array[String] = line.split(" ")

    if (stringArray.nonEmpty && stringArray.length > 1) {
      val customerID = CustomerID(stringArray(0), stringArray(1))
      customerID match {
        case CustomerID(list: String) => println(list) // выведет Sukyoung
        case _ => println("Could not extract a CustomerID")
      }
    } else println("Oops, something is wrong")
  } catch {
    case e: RuntimeException => println("Oops, something is wrong")
  }
  println(5/6)
}
