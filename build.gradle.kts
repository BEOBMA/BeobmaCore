import org.jetbrains.kotlin.gradle.dsl.KotlinJvmProjectExtension

plugins {
    kotlin("jvm") version "2.3.20-Beta2" apply false
    id("com.gradleup.shadow") version "8.3.0" apply false
    id("xyz.jpenilla.run-paper") version "2.3.1" apply false
}

group = "org.beobma"
version = "1.0-SNAPSHOT"

val paperApiVersion = "1.21.11-R0.1-SNAPSHOT"

subprojects {
    apply(plugin = "org.jetbrains.kotlin.jvm")

    repositories {
        mavenCentral()
        maven("https://repo.papermc.io/repository/maven-public/") {
            name = "papermc-repo"
        }
    }

    extra["paperApiVersion"] = paperApiVersion

    extensions.configure<KotlinJvmProjectExtension> {
        jvmToolchain(21)
    }
}
