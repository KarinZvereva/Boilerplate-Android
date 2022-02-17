plugins {
    id("com.android.application") version "7.1.1" apply false
    id("com.android.library") version "7.1.1" apply false
    kotlin("android") version "1.6.10" apply false

    // Navigation Safe Args
    id(Dependencies.Navigation.safeArgsPlugin) version Dependencies.Navigation.version apply false

    // Hilt
    id(Dependencies.Hilt.plugin) version Dependencies.Hilt.version apply false
}