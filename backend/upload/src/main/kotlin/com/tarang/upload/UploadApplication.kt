package com.tarang.upload

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

//@ConfigurationPropertiesScan
@SpringBootApplication
class UploadApplication

fun main(args: Array<String>) {
    println("Upload")
    runApplication<UploadApplication>(*args)
}