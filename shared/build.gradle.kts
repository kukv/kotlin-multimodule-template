import org.jetbrains.kotlin.gradle.plugin.KotlinJsCompilerType.IR

plugins {
    kotlin("multiplatform")
}

kotlin.jvm {
    compilations.all {
        kotlinOptions.jvmTarget = "17"
    }
}

kotlin.js(IR) {
    binaries.executable()
    browser {
        commonWebpackConfig {
            cssSupport.enabled = true
        }
        webpackTask {
            output.libraryTarget = "umd"
        }
        testTask {
            useKarma {
                useChromeHeadless()
                useFirefox()
            }
        }
    }
}

kotlin.sourceSets {
    val commonMain by getting {
        dependencies {
            implementation(kotlin("stdlib-common"))
        }
    }
    val commonTest by getting {
        dependencies {
            implementation(kotlin("test-common"))
            implementation(kotlin("test-annotations-common"))
        }
    }
    val jvmMain by getting {
        dependencies {
            implementation(kotlin("stdlib"))
        }
    }
    val jvmTest by getting {
        dependencies {
            implementation(kotlin("reflect"))
            implementation(kotlin("test"))
            implementation(kotlin("test-junit5"))
        }
    }
    val jsMain by getting {
        dependencies {
            implementation(kotlin("stdlib-js"))
        }
    }
    val jsTest by getting {
        dependencies {
            implementation(kotlin("test-js"))
        }
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
