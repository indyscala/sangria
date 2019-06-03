import Dependencies._

ThisBuild / scalaVersion     := "2.12.8"
ThisBuild / version          := "0.1.0-SNAPSHOT"
ThisBuild / organization     := "com.example"
ThisBuild / organizationName := "example"

lazy val root = (project in file("."))
  .settings(
    name := "GraphQL with Sangria",
    libraryDependencies += scalaTest % Test,
    libraryDependencies += "org.sangria-graphql" %% "sangria" % "1.4.2",
    libraryDependencies += "org.sangria-graphql" %% "sangria-circe" % "1.2.1",
  )

// See https://www.scala-sbt.org/1.x/docs/Using-Sonatype.html for instructions on how to publish to Sonatype.
