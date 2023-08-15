package com.tarang.stream

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

//@ConfigurationPropertiesScan
@SpringBootApplication
class CoreApiApplication

fun main(args: Array<String>) {
    println("Steam")
    runApplication<CoreApiApplication>(*args)
}