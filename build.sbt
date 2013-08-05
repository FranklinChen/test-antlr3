name := "test-antlr3"

organization := "com.franklinchen"

organizationHomepage := Some(url("http://franklinchen.com/"))

homepage := Some(url("http://github.com/FranklinChen/test-antlr3"))

startYear := Some(2013)

description := "Test ANTLR3 plugin with SBT Scala"

version := "1.0.0"

scalaVersion := "2.10.2"

libraryDependencies ++= Seq(
  "org.scalacheck" %% "scalacheck" % "1.10.1" % "test",
  "org.specs2" %% "specs2" % "2.1.1" % "test"
)

resolvers += Classpaths.typesafeReleases

resolvers += Classpaths.typesafeSnapshots

seq(sbtantlr.SbtAntlrPlugin.antlrSettings: _*)
