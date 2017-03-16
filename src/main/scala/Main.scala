import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.stream.ActorMaterializer
import http.Routes

import scala.io.StdIn

class Main extends Routes {

  def main(args: Array[String]): Unit = {

    implicit val system = ActorSystem("healify")
    implicit val materializer = ActorMaterializer()
    implicit val executionContext = system.dispatcher

    val bindingFuture = Http().bindAndHandle(route, "localhost", 8080)

    println(s"Server online at http://localhost:8080/\nPress RETURN to stop...")
    StdIn.readLine() // let it run until user presses return
    bindingFuture
      .flatMap(_.unbind()) // trigger unbinding from the port
      .onComplete(_ => system.terminate()) // and shutdown when done
  }

}
