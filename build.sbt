organization := "loostro"

name := "code-kata-dice-game-simulator"

version := "1.0"

scalaVersion := "2.12.1"

resolvers += "Typesafe repository" at "http://repo.typesafe.com/typesafe/releases/"

libraryDependencies ++= {

  val scalazV    = "7.2.8"
  val scalaTestV = "3.0.0"
  val scalaMockV = "3.4.2"

  Seq(
    "org.scalaz"    %% "scalaz-core"                 % scalazV,
    "org.scalatest" %% "scalatest"                   % scalaTestV % "test",
    "org.scalamock" %% "scalamock-scalatest-support" % scalaMockV % "test"
  )
}
