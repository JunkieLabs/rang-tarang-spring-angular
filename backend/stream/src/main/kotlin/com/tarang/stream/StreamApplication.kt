package com.tarang.stream

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.Bean

//@ConfigurationPropertiesScan
@SpringBootApplication
class StreamApplication{
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

fun main(args: Array<String>) {
    println("Steam")
    val  context = runApplication<StreamApplication>(*args)

    val mainFunction = context.getBean("mainFunction") as () -> Unit
    mainFunction.invoke()
}