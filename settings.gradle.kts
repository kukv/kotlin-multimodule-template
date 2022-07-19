enableFeaturePreview("VERSION_CATALOGS")
pluginManagement {
    plugins {
        kotlin("multiplatform") version "1.7.10"
        kotlin("js") version "1.7.10"
        kotlin("jvm") version "1.7.10"
    }
    repositories {
        google()
        mavenCentral()
        maven("https://maven.pkg.jetbrains.space/public/p/kotlinx-html/maven")
        gradlePluginPortal()
    }
}

rootProject.name = "kotlin-multimodule-template"
include("shared")
include("domain")
include("frontend:front")
include("frontend:front-admin")
include("backend:backend")
include("backend:backend-gateway")
include("database:database-exposed")
