name := "scala-mocking"

version := "0.1"

scalaVersion := "2.12.6"

libraryDependencies ++= Seq(
  "org.mockito" % "mockito-all" % "1.8.5" % Test,
  "org.scalatest" %% "scalatest" % "3.0.5" % Test
)
