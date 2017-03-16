package model

import akka.actor.ActorSystem
import akka.testkit.{ImplicitSender, TestActorRef, TestKit}
import org.scalatest.{BeforeAndAfterAll, Matchers, WordSpecLike}

class PatientTest extends TestKit(ActorSystem("PatientTest")) with WordSpecLike with ImplicitSender with Matchers with BeforeAndAfterAll{

  override def afterAll: Unit = {
    TestKit.shutdownActorSystem(system)
  }

  "Patient" must {

    val actorRef = TestActorRef[Patient]

    "respond with predefined meassage" in {
      actorRef ! "message"
      expectMsg("hello")
    }

    "respond with given message" in {
      actorRef ! Message("hello")
      expectMsg("hello")
    }

    "register new patient" in {
      actorRef ! Register("Jan", "Kowalski")
      expectMsg("registered")
    }

    "enroll patient in hospital" in {
      actorRef ! Enroll
      expectMsg("enrolled")
    }

    "unenroll patient from hospital" in {
      actorRef ! Unenroll
      expectMsg("unenrolled")
    }
  }

}
