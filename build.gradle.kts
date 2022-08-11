import org.gradle.kotlin.dsl.provider.inClassPathMode

buildscript {
    repositories {
        google()
        mavenCentral()
    }

}// Top-level build file where you can add configuration options common to all sub-projects/modules.


plugins {
    id(Dependencies.Plugins.applicationPlugin) version Dependencies.Plugins.version apply false
    id(Dependencies.Plugins.libraryPlugin) version Dependencies.Plugins.version apply false
    id(Dependencies.Plugins.kotlinPlugin) version Dependencies.Plugins.versionKotlinPlugin apply false
    id(Dependencies.Plugins.realmAndroid) version Dependencies.Plugins.realmVersion apply false
}


tasks {
    val clean by registering(Delete::class) {
        delete(buildDir)
    }
}
