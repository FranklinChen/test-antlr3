import sbt._
object PluginDef extends Build {
   override lazy val projects = Seq(root)
   lazy val root = Project("plugins", file(".")) dependsOn(antlr3Plugin)
   lazy val antlr3Plugin = uri("git://github.com/FranklinChen/sbt-antlr")
}
