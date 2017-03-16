import akka.http.scaladsl.testkit.ScalatestRouteTest
import http.Routes
import org.scalatest.{Matchers, WordSpec}

class RoutesTest extends WordSpec with Matchers with ScalatestRouteTest with Routes {

  "The service" should {

    "return greeting" in {
      Get("/hello") ~> route ~> check {
        responseAs[String] shouldEqual "Hello"
      }
    }

  }
}
