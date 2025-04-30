plugins {
    kotlin("jvm") version "2.1.20"
    `java-library`
    `maven-publish`
}

group = "org.ntqqrev.saltify"
version = "0.1.0"

repositories {
    mavenCentral()
}

dependencies {
    compileOnly("org.jetbrains.kotlinx:kotlinx-datetime:0.6.1")
    compileOnly("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.9.0")
}


kotlin {
    jvmToolchain(21)
}

java {
    withSourcesJar()
}

publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            groupId = project.group.toString()
            version = project.version.toString()
            artifactId = rootProject.name

            from(components["java"])
        }
    }
}