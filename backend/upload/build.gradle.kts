//
//plugins {
//
//    id("org.springframework.boot") version "3.1.2"
//    id("io.spring.dependency-management") version "1.1.2"
//
//    kotlin("jvm") version "1.9.0"
//    kotlin("plugin.spring") version "1.8.22"
////    application
//}
//
//group = "com.tarang"
//version = "1.0-SNAPSHOT"
//
//repositories {
//    mavenCentral()
//}

dependencies {
    implementation("org.springframework.integration:spring-integration-ftp")
    implementation("org.apache.ftpserver:ftpserver-core:1.2.0")

    // Apache Mina SSHD for FTPS
    implementation("org.apache.sshd:sshd-core:2.10.0") // Check for the latest version
    implementation("org.springframework.integration:spring-integration-ftp")

    // Add Apache FtpServer dependency


//    testImplementation(platform("org.junit:junit-bom:5.9.1"))
//    testImplementation("org.junit.jupiter:junit-jupiter")
}

//tasks.test {
////    useJUnitPlatform()
//}