plugins {
    kotlin("jvm")
}

dependencies {
    implementation(kotlin("stdlib"))

    testImplementation(kotlin("reflect"))
    testImplementation(kotlin("test"))
    testImplementation(kotlin("test-junit5"))
}
