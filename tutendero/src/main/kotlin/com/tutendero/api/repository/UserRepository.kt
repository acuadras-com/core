package com.tutendero.api.repository

import com.tutendero.api.model.User
import org.springframework.data.mongodb.repository.MongoRepository

interface UserRepository: MongoRepository<User, String>