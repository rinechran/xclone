buildscript {
    val objectboxVersion by extra("4.0.2") // For KTS build scripts

    repositories {
        mavenCentral()
    }

    dependencies {
        // Android Gradle Plugin 4.1.0 or later supported
        classpath("com.android.tools.build:gradle:8.6.0")
        classpath("io.objectbox:objectbox-gradle-plugin:$objectboxVersion")
    }
}

plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.jetbrains.kotlin.android) apply false
}