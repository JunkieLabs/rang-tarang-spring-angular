package com.tarang.upload

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.context.annotation.Bean
import org.springframework.core.env.ConfigurableEnvironment
import org.springframework.core.env.Environment


//@ConfigurationPropertiesScan
@SpringBootApplication
class UploadApplication{
    @Bean
    fun mainFunction(environment: ApplicationContext): () -> Unit {
        return {
            val propertyValue = environment.environment.getProperty("server.port")
            println("Property Value: $propertyValue")
            val propertyValue2 = environment.environment.getProperty("server.ss")
            println("Property Value 2: $propertyValue2")
        }
    }
}
//
//@Autowired()
//private var env: Environment? = null
fun main(args: Array<String>) {
    println("Upload")


    val context = runApplication<UploadApplication>(*args)
//
//    var context = AnnotationConfigApplicationContext()
//    val environment = context.environment as ConfigurableEnvironment
//    context.refresh()
//
//    val datasourceUrl = environment.toString()//getProperty("server.port")
//
    val mainFunction = context.getBean("mainFunction") as () -> Unit
    mainFunction.invoke()
}

