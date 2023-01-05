

plugins {
    java
    id("com.diffplug.spotless") version "6.12.1"
}

repositories {
    // Use the plugin portal to apply community plugins in convention plugins.
    gradlePluginPortal()
    mavenCentral()
}

configure<com.diffplug.gradle.spotless.SpotlessExtension> {
    java {
        target("**/*.java")
        importOrder()
        toggleOffOn()
        googleJavaFormat("1.15.0")
        removeUnusedImports()
        trimTrailingWhitespace()
        endWithNewline()
    }
}

subprojects {
    apply<CheckstylePlugin>()
    configure<CheckstyleExtension> {
        toolVersion = "10.6.0"
    }
}
