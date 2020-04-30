package com.tutendero.api.service.impl

import com.tutendero.api.model.User
import com.tutendero.api.repository.UserRepository
import com.tutendero.api.service.UserService
import com.tutendero.api.service.exception.ExistingResourceException
import com.tutendero.email.service.EmailService
import com.tutendero.email.model.Mail
import org.springframework.beans.factory.annotation.Value
import org.springframework.core.env.Environment
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserServiceImpl(
        private val userRepository: UserRepository,
        private val passwordEncoder: PasswordEncoder,
        private val emailService: EmailService,
        private val environment: Environment
) : UserService {

    override fun create(user: User): User? {
        if (user.id == null) {
            val existingUser : Optional<User?> = userRepository.findByUsername(user.username)
            if (!existingUser.isPresent) {
	            user.updatePassword(passwordEncoder.encode(user.password))
                user.createdAt = Date()
                val savedUser = userRepository.save(user)
                sendWelcomeEmail(savedUser)
                return savedUser
            } else {
                val username = user.username
                throw ExistingResourceException("User", "$username ya existe")
            }
        }
        return null
    }

    override fun update(user: User): User? {
        if (user.id != null) {
            user.updatedAt = Date()
            return userRepository.save(user)
        }
        return null
    }

    override fun delete(id: String) {
        val optionalUser = userRepository.findById(id)
        optionalUser.ifPresent { item: User ->
            item.disabled = true
            item.updatedAt = Date()
            userRepository.save(item)
        }
    }

    override fun findById(id: String): User? {
        val os = userRepository.findById(id)
        return os.orElse(null)
    }

    override fun findByUsername(username: String): User? {
        val os = userRepository.findByUsername(username)
        return os.orElse(null)
    }

    private fun sendWelcomeEmail(user: User) {
        val encoding = Base64.getUrlEncoder().encodeToString(user.id!!.toByteArray())
        println(encoding)
        val mail = Mail(user.username, "Bienvenido a Tutendero.co")
        val data: MutableMap<String, Any> = HashMap()
        data["name"] = user.name
        data["location"] = encoding
        val host = environment.getProperty("server.host")
        val context = environment.getProperty("server.servlet.context-path")
        var port = environment.getProperty("server.port")
        data["environment"] = "$host:$port$context"
        mail.props = data
        emailService.sendTemplateEmail(mail, "email/welcome-template")
    }
}