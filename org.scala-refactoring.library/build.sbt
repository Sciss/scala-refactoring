name := "org.scala-refactoring.library"

organization := "org.scala-refactoring"

version := "0.6.2-SNAPSHOT"

scalaVersion := "2.11.0-RC1"

crossScalaVersions := Seq("2.10.3")

publishMavenStyle := true

// artifactName := { (sv, module, artifact) =>
//  s"${name.value}_${sv.binary}-${module.revision}.${artifact.extension}"
// }

publishTo <<= version { (v: String) =>
  val nexus = "https://oss.sonatype.org/"
  if (v.trim.endsWith("SNAPSHOT"))
    Some("snapshots" at nexus + "content/repositories/snapshots")
  else
    Some("releases"  at nexus + "service/local/staging/deploy/maven2")
}

publishArtifact in Test := false

pomExtra := (
 <url>http://scala-refactoring.org</url>
  <licenses>
    <license>
      <name>Scala License</name>
      <url>http://www.scala-lang.org/node/146</url>
      <distribution>repo</distribution>
    </license>
  </licenses>
  <scm>
    <connection>scm:git:https://github.com/scala-ide/scala-refactoring.git</connection>
    <developerConnection>scm:git:git@github.com:scala-ide/scala-refactoring.git</developerConnection>
    <tag>master</tag>
    <url>https://github.com/scala-ide/scala-refactoring</url>
  </scm>
  <developers>
    <developer>
      <id>misto</id>
      <name>Mirko Stocker</name>
      <email>me@misto.ch</email>
    </developer>
  </developers>)

credentials += Credentials(Path.userHome / ".m2" / "credentials")

libraryDependencies += "org.scala-lang" % "scala-compiler" % scalaVersion.value

libraryDependencies += "com.novocode" % "junit-interface" % "0.10" % "test"

parallelExecution in Test := false
