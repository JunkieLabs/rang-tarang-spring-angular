package com.tarang.upload.config

import com.tarang.upload.ftp.CustomUserManager
import org.apache.ftpserver.FtpServer
import org.apache.ftpserver.FtpServerFactory
import org.apache.ftpserver.listener.ListenerFactory
import org.apache.ftpserver.usermanager.impl.BaseUser
import org.apache.ftpserver.usermanager.impl.WritePermission
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.io.File


// @Configuration
class FtpServerConfig {
//    @Bean(initMethod = "start", destroyMethod = "stop")
    fun ftpServer(): FtpServer {
        val serverFactory = FtpServerFactory()

        val factory = ListenerFactory()
        factory.port = 2221

//        factory.ssl = DefaultSsl(null) // Use DefaultSsl for simplicity, consider configuring your SSL options
//        factory.ssl.enabledProtocols = arrayOf("TLSv1.2") // Set the desired TLS protocol version(s)
//        factory.ssl.clientAuthentication = "need" /
        serverFactory.addListener("ftp", factory.createListener())

        // Add user
        println("ftp server")
        // Add user
        val user = BaseUser()
        user.name = "myuser"
        user.password = "1234"
        user.homeDirectory = "/ftp/root" // Set the FTP root directory
        user.authorities = listOf(WritePermission())
        user.maxIdleTime =0



        val userManager = CustomUserManager()
        userManager.save(user)

        serverFactory.userManager = userManager

        try {
//            val serverFactory = FtpServerFactory()

            // ... (your configuration code here) ...

            val s = serverFactory.createServer()

            println(s.isStopped) // Check server status

            return s
        } catch (ex: Exception) {

            println("ss")
            // Log the exception for troubleshooting
            ex.printStackTrace()
            throw ex // Rethrow the exception to stop the application startup
        }
    }
}