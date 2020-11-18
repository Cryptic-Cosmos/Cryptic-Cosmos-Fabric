plugins {
    id("fabric-loom") version "0.5-SNAPSHOT"
    java
    kotlin("jvm") version "1.4.0"
    idea
    id("net.minecrell.licenser") version "0.4.1"
    id("maven-publish")
}

fun property(name: String): Any = project.findProperty(name)!!

base.archivesBaseName = property("archives_base_name").toString()
version = property("mod_version")
group = property("maven_group")

repositories {
    maven("https://dl.bintray.com/user11681/maven")
}

dependencies {
    // To change the versions see the gradle.properties file
    minecraft("com.mojang:minecraft:${property("minecraft_version")}")
    mappings("net.fabricmc:yarn:${property("yarn_mappings")}:v2")
    modImplementation("net.fabricmc:fabric-loader:${property("loader_version")}")

    // Fabric API. This is technically optional, but you probably want it anyway.
    modImplementation("net.fabricmc.fabric-api:fabric-api:${property("fabric_version")}")

    // kotlin adapter
    modImplementation("net.fabricmc:fabric-language-kotlin:${property("fabric_kotlin_version")}")

    // yeet mojank console spam
    modRuntime("user11681:noauth:+")

    // PSA: Some older mods, compiled on Loom 0.2.1, might have outdated Maven POMs.
    // You may need to force-disable transitiveness on them.
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }

    processResources {
        inputs.property("version", project.version)

        filesMatching("fabric.mod.json") {
            expand("version" to project.version)
        }
    }

    jar {
        from("COPYING") {
            rename { "${it}_${project.base.archivesBaseName}" }
        }
    }
}

tasks.withType<JavaCompile>().configureEach {
    // ensure that the encoding is set to UTF-8, no matter what the system default is
    // this fixes some edge cases with special characters not displaying correctly
    // see http://yodaconditions.net/blog/fix-for-java-file-encoding-problems-with-gradle.html
    // If Javadoc is generated, this must be specified in that task too.
    options.encoding = "UTF-8"

    // The Minecraft launcher currently installs Java 8 for users, so your mod probably wants to target Java 8 too
    // JDK 9 introduced a new way of specifying this that will make sure no newer classes or methods are used.
    // We'll use that if it's available, but otherwise we'll use the older option.
    val targetVersion = "8"

    if (JavaVersion.current().isJava9Compatible) {
        options.compilerArgs.addAll(listOf("--release", targetVersion))
    }
}

java {
    // Loom will automatically attach sourcesJar to a RemapSourcesJar task and to the "build" task
    // if it is present.
    // If you remove this line, sources will not be generated.
    withSourcesJar()

    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

// this sets the header for licenser plugin to add
license {
    header = rootProject.file("LICENSE_HEADER.txt")

    ext {
        set("name", "Team MythosCraft")
        set("years", "2020")
        set("projectName", "MythosCraft")
    }

    include("**/*.java")
    include("**/*.kt")
}

// configure the maven publication
publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            // add all the jars that should be included when publishing to maven
            artifact(tasks.remapJar.get()) {
                builtBy(tasks.remapJar.get())
            }
            artifact(tasks["sourcesJar"]) {
                builtBy(tasks.remapSourcesJar.get())
            }
        }
    }

    // Select the repositories you want to publish to
    // To publish to maven local, no extra repositories are necessary. Just use the task `publishToMavenLocal`.
    repositories {
        // See https://docs.gradle.org/current/userguide/publishing_maven.html for information on how to set up publishing.
    }
}