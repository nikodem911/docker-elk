package org.demo.demoapp.exception

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class RandomExceptionController {
    val exceptions = listOf(
            RuntimeException("Fake RuntimeException"),
            IllegalStateException("Fake IllegalStateException"),
            IllegalArgumentException("Fake IllegalArgumentException")
    )

    @GetMapping("/exceptions")
    fun throwRandomException() {
        throw exceptions.random();
    }
}