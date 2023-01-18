plugins {
    id("java")
    id("org.jetbrains.intellij") version "1.10.1"
}

group = "com.aabushinov"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven {
        url = uri("https://repo.clojars.org")
        name = "Clojars"
    }
}

// Configure Gradle IntelliJ Plugin
// Read more: https://plugins.jetbrains.com/docs/intellij/tools-gradle-intellij-plugin.html
intellij {
    version.set("2021.2.4")
    type.set("IU") // Target IDE Platform

    plugins.set(listOf("terminal", "com.jetbrains.php:212.5712.51"))
}



tasks {
    // Set the JVM compatibility versions
    withType<JavaCompile> {
        sourceCompatibility = "11"
        targetCompatibility = "11"
    }

    runIde {
        ideDir.set(file("C:\\Program Files\\JetBrains\\PhpStorm 2021.2.3"))
    }

    patchPluginXml {
        sinceBuild.set("212")
        untilBuild.set("231.*")
    }

    signPlugin {
        certificateChain.set(System.getenv("CERTIFICATE_CHAIN"))
        privateKey.set(System.getenv("PRIVATE_KEY"))
        password.set(System.getenv("PRIVATE_KEY_PASSWORD"))
    }

    publishPlugin {
        token.set(System.getenv("PUBLISH_TOKEN"))
    }
}
