plugins {
    id("com.android.application") version "7.1.1" apply false
    id("com.android.library") version "7.1.1" apply false
    kotlin("android") version Dependencies.Versions.kotlin apply false

    // Dokka
    id("org.jetbrains.dokka") version Dependencies.Versions.kotlin

    // Navigation Safe Args
    id("androidx.navigation.safeargs.kotlin") version Dependencies.Versions.nav apply false
}

buildscript {
    dependencies {

        // Dokka
        classpath("org.jetbrains.dokka:dokka-gradle-plugin:${Dependencies.Versions.kotlin}")

        // Hilt
        classpath("com.google.dagger:hilt-android-gradle-plugin:${Dependencies.Versions.hilt}")
    }
}