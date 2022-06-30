import org.jetbrains.kotlin.gradle.plugin.KotlinJsCompilerType.IR

plugins {
    kotlin("js")
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
