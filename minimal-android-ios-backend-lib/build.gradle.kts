import org.jetbrains.kotlin.gradle.plugin.mpp.apple.XCFramework

plugins {
    kotlin("multiplatform") version "1.9.21"
    id("com.android.library") version "8.1.4"
    id("maven-publish")
}

group = "com.github.fernandospr"
version = "1.0.0"

kotlin {
    androidTarget {
        publishLibraryVariants("release", "debug")
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }

    jvm()

    val name = "MAIBLib"
    val xcf = XCFramework(name)
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = name
            xcf.add(this)
            isStatic = true
        }
    }

    sourceSets {
        commonMain.dependencies {}
        jvmMain.dependencies {}
        androidMain.dependencies {}
        iosMain.dependencies {}
        commonTest.dependencies {
            implementation(kotlin("test"))
        }
    }
}

android {
    namespace = "com.github.fernandospr"
    compileSdk = 34
    defaultConfig {
        minSdk = 24
    }
}