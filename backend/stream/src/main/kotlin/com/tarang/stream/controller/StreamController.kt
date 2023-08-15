package com.tarang.stream.controller

import com.tarang.stream.model.Item
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.time.Duration
import java.time.Instant
import java.util.stream.Stream

@RestController
@RequestMapping("/api")
class StreamController {

    @GetMapping("/stream")
    fun streamItems(): Stream<Item> {
        val startInstant = Instant.now()
        return Stream.generate {
            Item("Item ${
                Duration.between(startInstant,Instant.now())}")
        }.limit(10) // Stream 10 items
    }
}