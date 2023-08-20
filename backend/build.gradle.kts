import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {

    id("org.springframework.boot") version "3.1.2"
    id("io.spring.dependency-management") version "1.1.2"

    kotlin("jvm") version "1.9.0"
    kotlin("plugin.spring") version "1.8.22"
//    application
}

group = "com.tarang"
version = "1.0-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_17

}



repositories {
    mavenCentral()
}



subprojects {


    group = "com.tarang"
    version = "1.0-SNAPSHOT"
//    apply(plugin = "java")
//    apply(plugin = "org.jetbrains.kotlin.jvm")

//    apply(plugin = "org.springframework.boot")

    apply {
        plugin("io.spring.dependency-management")
        plugin("org.springframework.boot")
        plugin("org.jetbrains.kotlin.jvm")
        plugin("org.jetbrains.kotlin.plugin.spring")
//        plugin("com.google.cloud.tools.jib")
    }

    dependencies {
        implementation(kotlin("stdlib"))

        implementation("org.springframework.boot:spring-boot-starter-web")
        // Other shared dependencies
    }

    repositories {
        mavenCentral()
    }
}

dependencies {

    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
//    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions {

        freeCompilerArgs += "-Xjsr305=strict"
        jvmTarget = "17"
    }
}

tasks.withType<JavaCompile> {
    options.compilerArgs.plusAssign("-jvm-target=17")
}




//kotlin {
//    jvmToolchain(17)
//
//}

//application {
//    mainClass.set("MainKt")
//}