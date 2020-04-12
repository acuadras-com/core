package com.tutendero.api.service.impl

import com.tutendero.api.model.User
import com.tutendero.api.repository.UserRepository
import com.tutendero.api.service.UserService
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserServiceImpl(
        private val userRepository: UserRepository
) : UserService {

    override fun create(user: User): User? {
        if (user.id == null) {
            user.createdAt = Date()
            return userRepository.save(user)
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

}