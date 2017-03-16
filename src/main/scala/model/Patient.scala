package model

import akka.actor.Actor
import akka.event.Logging

case class Enroll()
case class Unenroll()
case class Message(msg: String)
case class Register(name: String, lastName: String)

class Patient extends Actor {
  val log = Logging(context.system, this)

  private var name: String = ""
  private var lastName: String = ""

  def receive: Receive = {
    case Message(text) => sender ! text
    case Register(a, b) =>
      this.name = a
      this.lastName = b
      context.become(unenrolled)
      sender ! "registered"
    case _ => sender ! "hello"
  }

  def enrolled: Receive = {
    case Unenroll =>
      context.become(unenrolled)
      sender ! "unenrolled"
    case _ => sender ! "enrolled"
  }

  def unenrolled: Receive = {
    case Enroll =>
      context.become(enrolled)
      sender ! "enrolled"
    case _ => sender ! "unenrolled"
  }
}
