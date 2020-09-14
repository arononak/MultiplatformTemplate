buildscript {
    repositories {
        gradlePluginPortal()
        jcenter()
        google()
        mavenCentral()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:4.2.0-alpha03")

        val kotlinVersion = "1.4.0"
        classpath(kotlin("gradle-plugin", version = kotlinVersion))
        classpath(kotlin("serialization", version = kotlinVersion))
        classpath("com.squareup.sqldelight:gradle-plugin:1.4.3")
    }
}
group = "com.example.multiplatformtemplate"
version = "1.0-SNAPSHOT"

extra.set("kodeinVersion", "7.0.0")

repositories {
    mavenCentral()
    maven(url = "https://dl.bintray.com/kodein-framework/kodein-dev")
    maven(url = "https://kotlin.bintray.com/kotlinx")
    maven(url = "https://kotlin.bintray.com/kotlin")
    maven(url = "https://kotlin.bintray.com/ktor")
}
