val paperApiVersion: String by project

plugins {
    id("com.gradleup.shadow")
    id("xyz.jpenilla.run-paper")
}

dependencies {
    compileOnly("io.papermc.paper:paper-api:$paperApiVersion")
    implementation(project(":core-api"))
    implementation(project(":core-impl"))
}

tasks {
    runServer {
        minecraftVersion("1.21")
    }

    build {
        dependsOn(shadowJar)
    }

    processResources {
        val props = mapOf("version" to project.version)
        inputs.properties(props)
        filteringCharset = "UTF-8"
        filesMatching("plugin.yml") {
            expand(props)
        }
    }
}
