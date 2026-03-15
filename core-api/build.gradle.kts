val paperApiVersion: String by project

dependencies {
    implementation(kotlin("stdlib"))
    compileOnly("io.papermc.paper:paper-api:$paperApiVersion")
}
