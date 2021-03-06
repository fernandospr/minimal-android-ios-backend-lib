import org.jetbrains.kotlin.gradle.plugin.mpp.apple.XCFramework

plugins {
    kotlin("multiplatform") version "1.6.21"
    id("maven-publish")
}

val libName = "MAIBLib"
group = "com.github.fernandospr"
version = "1.0.0"

repositories {
    mavenCentral()
}

kotlin {
    val xcFramework = XCFramework(libName)
    ios {
        binaries.framework(libName) {
            xcFramework.add(this)
        }
    }
    jvm {
        compilations.all {
            kotlinOptions.jvmTarget = "1.8"
        }
        withJava()
        testRuns["test"].executionTask.configure {
            useJUnitPlatform()
        }
    }
    sourceSets {
        val commonMain by getting
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
    }
}
