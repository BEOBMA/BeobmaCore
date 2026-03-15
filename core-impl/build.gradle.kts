val paperApiVersion: String by rootProject.extra

dependencies {
    implementation(project(":core-api"))
    compileOnly("io.papermc.paper:paper-api:$paperApiVersion")
}
