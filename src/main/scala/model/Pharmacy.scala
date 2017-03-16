package model

import akka.actor.Actor
import akka.actor.Actor.Receive

class Pharmacy extends Actor {

  override def receive: Receive = {
    case _ => sender ! "hello"
  }
}
