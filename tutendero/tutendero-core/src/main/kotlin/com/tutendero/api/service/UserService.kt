package com.tutendero.api.service

import com.tutendero.api.model.User

interface UserService {
    fun create(user: User): User?
    fun update(user: User): User?
    fun delete(id: String)
    fun findById(id: String): User?
    fun findByUsername(username: String): User?
}