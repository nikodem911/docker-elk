package org.demo.demoapp.user

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController {

    @GetMapping("/users")
    fun getAllUsers(): List<User> {
        return listOf(
                User("1", "John", "Rambo"),
                User("2", "John", "McLane"),
                User("3", "Bruce", "Wayne")
        )
    }

    @GetMapping("/users/{userId}")
    fun getUser(@PathVariable userId: String): User {
        return User(userId, "FirstName", "LastName")
    }
}