package com.tutendero.api.repository

import com.tutendero.api.model.Conversation
import org.springframework.data.mongodb.repository.MongoRepository
import java.util.*

interface ConversationRepository: MongoRepository<Conversation, String> {
    fun findByCustomerId(id: String): Optional<Conversation>
    fun findByShopId(id: String): Optional<Conversation>
}