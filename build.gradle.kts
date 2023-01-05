

plugins {
    id("com.diffplug.spotless") version "6.12.1"
}

repositories {
    // Use the plugin portal to apply community plugins in convention plugins.
    gradlePluginPortal()
}

configure<com.diffplug.gradle.spotless.SpotlessExtension> {
    java {
        target("**/*.java")
        importOrder()
        toggleOffOn()
        googleJavaFormat()
        removeUnusedImports()
        trimTrailingWhitespace()
        endWithNewline()
    }
}
