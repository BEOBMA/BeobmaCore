val paperApiVersion: String by project

dependencies {
    implementation(project(":core-api"))
    compileOnly("io.papermc.paper:paper-api:$paperApiVersion")
}
