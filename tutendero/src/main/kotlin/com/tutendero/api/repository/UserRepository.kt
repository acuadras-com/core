package com.tutendero.api.repository

import com.tutendero.api.model.User
import org.bson.types.ObjectId
import org.springframework.data.mongodb.repository.MongoRepository
import java.util.*

interface UserRepository : MongoRepository<User, ObjectId> {
    fun findByEmail(email: String): Optional<User>
}