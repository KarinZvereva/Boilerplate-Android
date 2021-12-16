buildscript {
    repositories {
        google()
        mavenCentral()
        maven { url = uri("https://jitpack.io") }
    }
    dependencies {
        classpath("com.android.tools.build:gradle:7.0.4")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.10")

        // Navigation Safe Args
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:${Dependencies.Versions.nav}")

        // Hilt
        classpath("com.google.dagger:hilt-android-gradle-plugin:${Dependencies.Versions.hilt}")
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
        maven { url = uri("https://jitpack.io") }
    }
}