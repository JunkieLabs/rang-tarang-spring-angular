package com.tarang.upload.config

import org.apache.ftpserver.FtpServer
import org.apache.ftpserver.FtpServerFactory
import org.apache.ftpserver.listener.ListenerFactory
import org.apache.ftpserver.usermanager.ClearTextPasswordEncryptor
import org.apache.ftpserver.usermanager.PropertiesUserManagerFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.io.ClassPathResource
import java.io.File

@Configuration
class FtpServerConfiguration {

    @Bean(initMethod = "start", destroyMethod = "stop")
    fun ftpServer(): FtpServer {
        val serverFactory = FtpServerFactory()

        println("server 1: ")
        // Create a listener with your desired configuration
        val factory = ListenerFactory()
        factory.port = 2121 // Set the FTP server port
        serverFactory.addListener("default", factory.createListener())

        // Configure user accounts using a properties file
        val userManagerFactory = PropertiesUserManagerFactory()
        userManagerFactory.passwordEncryptor = ClearTextPasswordEncryptor()
        val usersPropertiesFile = ClassPathResource("users.properties").file
        userManagerFactory.setFile(usersPropertiesFile)

        userManagerFactory.passwordEncryptor = ClearTextPasswordEncryptor()
//        userManagerFactory.setFile(File("users.properties")) // Set the path to the properties file
        val userManager = userManagerFactory.createUserManager()
        serverFactory.setUserManager(userManager)
        val server = serverFactory.createServer()


        println("server: ")
        return server
    }
}