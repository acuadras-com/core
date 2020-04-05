package com.tutendero.api.service.impl

import com.tutendero.api.model.Conversation
import com.tutendero.api.repository.ConversationRepository
import com.tutendero.api.service.ConversationService
import org.bson.types.ObjectId
import org.springframework.stereotype.Service
import java.util.*

@Service
class ConversationServiceImpl(private val conversationRepository: ConversationRepository) : ConversationService {
    override fun create(conversation: Conversation): Conversation? {
        if (conversation.id == null) {
            conversation.createdDate = Date()
            return conversationRepository.save(conversation)
        }
        return null
    }

    override fun update(conversation: Conversation): Conversation? {
        if (conversation.id != null) {
            conversation.updatedDate = Date()
            return conversationRepository.save(conversation)
        }
        return null
    }

    override fun delete(id: String) {
        val optionalConversation = conversationRepository.findById(id)
        optionalConversation.ifPresent { item: Conversation ->
            item.disabled = true
            item.updatedDate = Date()
            conversationRepository.save(item)
        }
    }

    override fun findById(id: String): Conversation? {
        val oc = conversationRepository.findById(id)
        return oc.orElse(null)
    }

    override fun findByCustomerId(id: String): Conversation? {
        val oc: Optional<Conversation> = conversationRepository.findByCustomerId(id)
        return oc.orElse(null)
    }

    override fun findByShopId(id: String): Conversation? {
        val oc: Optional<Conversation> = conversationRepository.findByShopId(id)
        return oc.orElse(null)
    }

}