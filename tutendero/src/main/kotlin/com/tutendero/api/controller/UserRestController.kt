package com.tutendero.api.controller

import com.tutendero.api.model.User
import com.tutendero.api.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/user")
class UserRestController(
        private val userService: UserService
) {

    @GetMapping("/{id}")
    fun getUser(@PathVariable id: String?): ResponseEntity<User> {
        if (id == null) {
            return ResponseEntity(HttpStatus.BAD_REQUEST)
        }
        val user: User? = userService.findById(id)
        return if (user != null) {
            ResponseEntity(user, HttpStatus.OK)
        } else ResponseEntity(HttpStatus.OK)
    }

    @PostMapping
    fun createUser(@RequestBody user: @Valid User): ResponseEntity<User> {
        if (user.id != null) {
            return ResponseEntity(HttpStatus.BAD_REQUEST)
        }
        val savedUser: User? = userService.create(user)
        return ResponseEntity(savedUser, HttpStatus.OK)
    }

    @PutMapping
    fun updateUser(@RequestBody user: @Valid User): ResponseEntity<User> {
        if (user.id == null) {
            return ResponseEntity(HttpStatus.BAD_REQUEST)
        }
        val savedUser: User? = userService.update(user)
        return ResponseEntity(savedUser, HttpStatus.OK)
    }

    @DeleteMapping("/{id}")
    fun deleteUser(@PathVariable id: String?): ResponseEntity<User> {
        if (id == null) {
            return ResponseEntity(HttpStatus.BAD_REQUEST)
        }
        userService.delete(id)
        return ResponseEntity(HttpStatus.OK)
    }
}
