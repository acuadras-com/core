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
    fun getShop(@PathVariable id: String?): ResponseEntity<User> {
        if (id == null) {
            return ResponseEntity(HttpStatus.BAD_REQUEST)
        }
        val user: User? = userService.findById(id)
        return if (user != null) {
            ResponseEntity(user, HttpStatus.OK)
        } else ResponseEntity(HttpStatus.OK)
    }

    @PostMapping
    fun createShop(@RequestBody shop: @Valid User): ResponseEntity<User> {
        if (shop.id != null) {
            return ResponseEntity(HttpStatus.BAD_REQUEST)
        }
        val savedShop: User? = userService.create(shop)
        return ResponseEntity(savedShop, HttpStatus.OK)
    }

    @PutMapping
    fun updateShop(@RequestBody shop: @Valid User): ResponseEntity<User> {
        if (shop.id == null) {
            return ResponseEntity(HttpStatus.BAD_REQUEST)
        }
        val savedShop: User? = userService.update(shop)
        return ResponseEntity(savedShop, HttpStatus.OK)
    }

    @DeleteMapping("/{id}")
    fun deleteShop(@PathVariable id: String?): ResponseEntity<User> {
        if (id == null) {
            return ResponseEntity(HttpStatus.BAD_REQUEST)
        }
        userService.delete(id)
        return ResponseEntity(HttpStatus.OK)
    }
}