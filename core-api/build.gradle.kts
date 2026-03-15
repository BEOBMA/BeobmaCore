val paperApiVersion: String by rootProject.extra

dependencies {
    implementation(kotlin("stdlib"))
    compileOnly("io.papermc.paper:paper-api:$paperApiVersion")
}
