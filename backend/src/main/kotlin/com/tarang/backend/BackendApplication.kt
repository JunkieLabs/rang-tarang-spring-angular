package com.tarang.backend

//package com.tarang.backend

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BackendApplication

fun main(args: Array<String>) {
//    print("Dsds")
    runApplication<BackendApplication>(*args)
}
