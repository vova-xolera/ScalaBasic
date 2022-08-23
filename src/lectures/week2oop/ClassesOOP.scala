package lectures.week2oop

import scala.concurrent.duration.Duration.Inf

object ClassesOOP extends App {
  trait Configs {
    val ACCOUNT_TYPE_DEFAULT = "free"
    val ACCOUNT_TYPE_PAID = "paid"
    val SUBSCRIPTION_STATUS = "active"
  }

  object Settings {
    case class AccountSettings(
                                email: String,
                                password: String,
                                picture: String)

    case class SubscriptionSettings(
                                     payment: String,
                                     notifications: String,
                                     expiration: String)
  }

  trait Subscriber extends Configs {
    def subscribe(settings: Settings.SubscriptionSettings): Unit = println("subscribed")
  }

  trait Unsubscriber extends Configs {
    def unsubscribe(): Unit = println("unsubscribed")
  }

  abstract class Account(accountID: String, settings: Settings.AccountSettings) extends Configs {
    def info(): Unit
  }

  class FreeAccount(
                     accountID: String,
                     settings: Settings.AccountSettings) extends Account(accountID, settings) with Subscriber {

    override def info(): Unit = println(s"Account Type: $ACCOUNT_TYPE_DEFAULT")
  }

  class PaidAccount(
                     accountID: String,
                     settings: Settings.AccountSettings) extends Account(accountID, settings) with Unsubscriber {

    override def info(): Unit = {
      println(s"Account Type: $ACCOUNT_TYPE_PAID")
      println(s"Subscription Status: $SUBSCRIPTION_STATUS")
    }
  }

  class MusicInstrument[+A](productionYear: Int) {
  }

  case class Guitar(productionYear: Int) extends MusicInstrument(5)

  case class Piano(productionYear: Int) extends MusicInstrument(-5)

  val guitar = Guitar.apply(2021)
  println(guitar)

  class Person(name: String) {
    def unary_+ : Person = {
      new Person (name + " NoSurname")
    }
  }

  val person = new Person("Bob")


}
