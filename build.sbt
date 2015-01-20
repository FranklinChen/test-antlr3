name := "test-antlr3"

organization := "com.franklinchen"

organizationHomepage := Some(url("http://franklinchen.com/"))

homepage := Some(url("http://github.com/FranklinChen/test-antlr3"))

startYear := Some(2013)

description := "Test ANTLR3 plugin with SBT Scala"

version := "1.0.0"

scalaVersion := "2.11.5"

javacOptions += "-Xlint:unchecked"

libraryDependencies ++= Seq(
  "org.scalacheck" %% "scalacheck" % "1.12.1" % "test",
  "org.specs2" %% "specs2" % "2.4.15" % "test"
)

seq(sbtantlr.SbtAntlrPlugin.antlrSettings: _*)

resolvers += "Scalaz Bintray Repo" at "http://dl.bintray.com/scalaz/releases"
