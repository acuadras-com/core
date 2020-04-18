package com.tutendero.api.controller

import com.tutendero.api.controller.request.AuthenticationRequest
import com.tutendero.api.model.User
import com.tutendero.api.model.UserDto
import com.tutendero.api.model.toDto
import com.tutendero.api.model.toEntity
import com.tutendero.api.security.jwt.JwtTokenProvider
import com.tutendero.api.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.BadCredentialsException
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.AuthenticationException
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*
import javax.validation.Valid

@RestController
@RequestMapping("/auth")
class AuthController(
        private var authenticationManager: AuthenticationManager,
        private var jwtTokenProvider: JwtTokenProvider,
        private var userService: UserService
) {

    @PostMapping("/signin")
    fun signin(@RequestBody request: AuthenticationRequest): ResponseEntity<*> {
        return try {
            val username = request.username
            authenticationManager.authenticate(UsernamePasswordAuthenticationToken(username, request.password))
            val user: User = userService.findByUsername(username)
                    ?: throw UsernameNotFoundException("Username $username not found")
            val token = jwtTokenProvider.createToken(username, user.roles)
            val model: MutableMap<Any, Any?> = HashMap()
            model["username"] = username
            model["token"] = token
            ResponseEntity.ok<Map<Any, Any?>>(model)
        } catch (e: AuthenticationException) {
            throw BadCredentialsException("Invalid username or password")
        }
    }

    @PostMapping("/signup")
    fun signup(@RequestBody userDto: @Valid UserDto): ResponseEntity<*> {
        val createdUser: User? = userService.create(userDto.toEntity())
        val userDto = createdUser!!.toDto()
        return ResponseEntity(userDto, HttpStatus.OK)
    }

}