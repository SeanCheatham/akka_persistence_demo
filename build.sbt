name := "akka_persistence_demo"

version := "0.1"

scalaVersion := "2.12.8"
organization := "com.seancheatham"

libraryDependencies ++=
  Dependencies.akka ++
    Dependencies.akkaPersistence ++
    Dependencies.playJson ++
    Dependencies.typesafe ++
    Dependencies.test ++
    Dependencies.logging