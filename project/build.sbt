resolvers += "stefri" at "http://stefri.github.com/repo/releases"

// TODO Put back when SBT 0.13 supported.
//addSbtPlugin("com.github.stefri" % "sbt-antlr" % "0.5")

// TODO Workaround until SBT 0.13 supported.
lazy val root = project in file(".") dependsOn antlrPlugin
lazy val antlrPlugin = uri("git://github.com/Blaisorblade/sbt-antlr#sbt0.13")
