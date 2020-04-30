package com.tutendero.api.controller

import com.tutendero.api.model.User
import com.tutendero.api.service.UserService
import org.springframework.beans.factory.annotation.Value
import org.springframework.core.env.Environment
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*
import javax.validation.Valid

@RestController
@RequestMapping("/user")
class UserRestController(
        private val userService: UserService
) {


    @GetMapping("/{id}")
    @CrossOrigin
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
    @CrossOrigin
    fun createUser(@RequestBody user: @Valid User): ResponseEntity<User?> {
        if (user.id != null) {
            return ResponseEntity(HttpStatus.BAD_REQUEST)
        }
        val savedUser: User? = userService.create(user)
        return ResponseEntity(savedUser, HttpStatus.OK)
    }

    @PutMapping
    @CrossOrigin
    fun updateUser(@RequestBody user: @Valid User): ResponseEntity<User?> {
        if (user.id == null) {
            return ResponseEntity(HttpStatus.BAD_REQUEST)
        }
        val savedUser: User? = userService.update(user)
        return ResponseEntity(savedUser, HttpStatus.OK)
    }

    @DeleteMapping("/{id}")
    @CrossOrigin
    fun deleteUser(@PathVariable id: String?): ResponseEntity<User> {
        if (id == null) {
            return ResponseEntity(HttpStatus.BAD_REQUEST)
        }
        userService.delete(id)
        return ResponseEntity(HttpStatus.OK)
    }

    @GetMapping("/confirm/{location}")
    fun confirmUser(@PathVariable location: String): ResponseEntity<String> {

        val id = String(Base64.getUrlDecoder().decode(location))
        val user : User? = userService.findById(id)
        if (user != null && !user.confirmed) {
            user.confirmed = true
            userService.update(user)
        }
        return ResponseEntity<String>("Correo confirmado!", HttpStatus.OK)
    }
}
