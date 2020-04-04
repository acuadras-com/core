package com.tutendero.api.controller

import com.tutendero.api.model.User
import com.tutendero.api.repository.UserRepository
import org.bson.types.ObjectId
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*
import javax.validation.Valid

@RestController
@RequestMapping("/user")
class UserRestController(
        private val userRepository: UserRepository
) {
    @GetMapping("/{ids}")
    @CrossOrigin
    fun getUser(@PathVariable ids: String?): ResponseEntity<User> {
        if (ids == null) {
            return ResponseEntity(HttpStatus.BAD_REQUEST)
        }
        val ou: Optional<User> = userRepository.findById(ObjectId(ids))
        return if (ou.isPresent) {
            ResponseEntity(ou.get(), HttpStatus.OK)
        } else ResponseEntity(HttpStatus.OK)
    }

    @PostMapping
    @CrossOrigin
    fun createUser(@RequestBody user: @Valid User): ResponseEntity<User> {
        if (user.id != null) {
            return ResponseEntity(HttpStatus.BAD_REQUEST)
        }
        val savedUser: User = userRepository.save(user)
        return ResponseEntity(savedUser, HttpStatus.OK)
    }

    @PutMapping
    @CrossOrigin
    fun updateUser(@RequestBody user: @Valid User): ResponseEntity<User> {
        if (user.id == null) {
            return ResponseEntity(HttpStatus.BAD_REQUEST)
        }
        val savedUser: User = userRepository.save(user)
        return ResponseEntity(savedUser, HttpStatus.OK)
    }
}