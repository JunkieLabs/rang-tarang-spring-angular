package com.tarang.stream

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

//@ConfigurationPropertiesScan
@SpringBootApplication
class StreamApplication

fun main(args: Array<String>) {
    println("Steam")
    runApplication<StreamApplication>(*args)
}