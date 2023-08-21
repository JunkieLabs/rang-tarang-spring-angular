package com.tarang.backend

//package com.tarang.backend

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.Bean

@SpringBootApplication
class BackendApplication{
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
//    print("Dsds")
    val context = runApplication<BackendApplication>(*args)

    val mainFunction = context.getBean("mainFunction") as () -> Unit
    mainFunction.invoke()
}
