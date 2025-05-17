plugins {
    kotlin("jvm") version "2.0.21"
    id("com.gradleup.shadow") version "8.3.0"
    id("xyz.jpenilla.run-paper") version "2.3.1"
    id("com.typewritermc.module-plugin") version "1.1.3"
}

group = "net.mytheria"
version = "1.0-SNAPSHOT"
typewriter {
    namespace = "mytheria"

    extension {

        name = "ProfileExt"
        shortDescription = "Ext213123123123"
        description = "This extension provides a way to create story designssdsada  dsadasd a sda dasdadasd asd as das da dsa da da da das das da dsada"
        engineVersion = "0.8.0"
        channel = com.typewritermc.moduleplugin.ReleaseChannel.BETA

        dependencies {}

        paper()
    }
}
repositories {
    mavenCentral()
    maven("https://repo.papermc.io/repository/maven-public/") {
        name = "papermc-repo"
    }
    maven("https://oss.sonatype.org/content/groups/public/") {
        name = "sonatype"
    }
    maven("https://nexus.phoenixdevt.fr/repository/maven-public/")
}

dependencies {
    compileOnly("io.papermc.paper:paper-api:1.21.4-R0.1-SNAPSHOT")
    compileOnly ("io.lumine:MythicLib-dist:1.6.2-SNAPSHOT")
    compileOnly ("net.Indyuce:MMOCore-API:1.12.1-SNAPSHOT")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
}

tasks {
    runServer {
        // Configure the Minecraft version for our task.
        // This is the only required configuration besides applying the plugin.
        // Your plugin's jar (or shadowJar if present) will be used automatically.
        minecraftVersion("1.21")
    }
}

val targetJavaVersion = 21
kotlin {
    jvmToolchain(targetJavaVersion)
}

tasks.build {
    dependsOn("shadowJar")
}

tasks.processResources {
    val props = mapOf("version" to version)
    inputs.properties(props)
    filteringCharset = "UTF-8"
    filesMatching("plugin.yml") {
        expand(props)
    }
}
