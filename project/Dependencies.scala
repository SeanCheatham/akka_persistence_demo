import sbt._

object Dependencies {

  object Versions {
    val akka = "2.5.23"
    val levelDB = "1.8"
    val play = "2.7.2"
    val scalaTest = "3.0.1"
  }

  val akka =
    Seq(
      "com.typesafe.akka" %% "akka-actor" % Versions.akka
    )

  val akkaPersistence =
    Seq(
      "com.typesafe.akka" %% "akka-persistence" % Versions.akka,
      "org.fusesource.leveldbjni" % "leveldbjni-all" % Versions.levelDB
    )

  val playJson =
    Seq(
      "com.typesafe.play" %% "play-json" % Versions.play
    )

  val typesafe =
    Seq(
      "com.typesafe" % "config" % "1.3.4"
    )

  val test =
    Seq(
      "org.scalatest" %% "scalatest" % Versions.scalaTest % "test"
    )

  val logging =
    Seq(
      "ch.qos.logback" % "logback-classic" % "1.1.7",
      "com.typesafe.scala-logging" %% "scala-logging" % "3.5.0"
    )

}
