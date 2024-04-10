ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.4.1"

Global / onChangedBuildSource := ReloadOnSourceChanges

lazy val root = (project in file("."))
  .settings(
    name := "Sandbox",
    libraryDependencies += "org.wvlet.airframe" %% "airframe-surface" % "24.4.0",
    scalacOptions ++= Seq(
      "-unchecked",
      "-feature",
      "-deprecation",
    )
  )
