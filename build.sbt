name := "test-antlr3"

organization := "com.franklinchen"

scalaVersion := "2.10.0"

libraryDependencies ++= Seq(
  "org.antlr" % "antlr-runtime" % "3.5")

seq(sbtantlr.SbtAntlrPlugin.antlrSettings: _*)
