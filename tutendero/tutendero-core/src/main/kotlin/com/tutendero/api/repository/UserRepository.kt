package com.tutendero.api.repository

import com.tutendero.api.model.User
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository: MongoRepository<User, String> {
    fun findByUsername(username: String) : User?
}