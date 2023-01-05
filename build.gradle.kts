plugins {
    java
    id("com.diffplug.spotless") version "6.12.1"
    id("com.github.spotbugs") version "5.0.13"
}

repositories {
    // Use the plugin portal to apply community plugins in convention plugins.
    gradlePluginPortal()
    mavenCentral()
}

dependencies {
    spotbugs("com.github.spotbugs:spotbugs:4.7.3")
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
    apply<com.github.spotbugs.snom.SpotBugsPlugin>()
    configure<CheckstyleExtension> {
        toolVersion = "10.6.0"
    }
    configure<com.github.spotbugs.snom.SpotBugsExtension> {
        ignoreFailures.set(false)
        showStackTraces.set(true)
        showProgress.set(true)
        effort.set(com.github.spotbugs.snom.Effort.MAX)
        reportLevel.set(com.github.spotbugs.snom.Confidence.MAX_VALUE)
        //visitors.set(listOf("FindSqlInjection", "SwitchFallthrough"))
        //omitVisitors.set(listOf("FindNonShortCircuit"))
        reportsDir.set(file("$buildDir/spotbugs"))
        //includeFilter.set(file("include.xml"))
        //excludeFilter.set(file("exclude.xml"))
        //baselineFile.set(file("baseline.xml"))
        //onlyAnalyze.set(listOf("com.foobar.MyClass", "com.foobar.mypkg.*"))
        maxHeapSize.set("1g")
        //extraArgs.set(listOf("-nested:false"))
        //jvmArgs.set(listOf("-Duser.language=ja"))
    }
}
