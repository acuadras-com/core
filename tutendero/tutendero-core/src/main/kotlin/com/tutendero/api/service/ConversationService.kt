package com.tutendero.api.service

import com.tutendero.api.model.Conversation

interface ConversationService {
    fun create(conversation: Conversation): Conversation?
    fun update(conversation: Conversation): Conversation?
    fun delete(id: String)
    fun findById(id: String): Conversation?
    fun findByCustomerId(id: String): Conversation?
    fun findByShopId(id: String): Conversation?
}