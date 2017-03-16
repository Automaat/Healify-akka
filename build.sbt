name := "Healify"

version := "1.0"

scalaVersion := "2.12.1"

libraryDependencies ++= {
  val akkaHttpV = "10.0.4"
  val akkaV = "2.4.17"
  val scalaTestV = "3.0.1"

  Seq(
    "com.typesafe.akka" %% "akka-persistence" % akkaV,

    "com.typesafe.akka" %% "akka-http-core" % akkaHttpV,
    "com.typesafe.akka" %% "akka-http" % akkaHttpV,

    "org.scalatest" %% "scalatest" % scalaTestV % "test",
    "com.typesafe.akka" %% "akka-http-testkit" % akkaHttpV % "test"
  )
}
    