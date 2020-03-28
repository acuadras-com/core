package com.tutendero.api.controller

import com.tutendero.api.model.Conversation
import com.tutendero.api.repository.ConversationRepository
import org.bson.types.ObjectId
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*
import javax.validation.Valid

@RestController
@RequestMapping("/conversation")
class ConversationRestController(
        private val conversationRepository: ConversationRepository
) {
    @GetMapping("/{id}")
    fun getShop(@PathVariable id: String?): ResponseEntity<Conversation> {
        if (id == null) {
            return ResponseEntity(HttpStatus.BAD_REQUEST)
        }
        val ot: Optional<Conversation> = conversationRepository.findById(ObjectId(id))
        return if (ot.isPresent) {
            ResponseEntity(ot.get(), HttpStatus.OK)
        } else ResponseEntity(HttpStatus.OK)
    }

    @PostMapping
    fun createConversation(@RequestBody conversation: @Valid Conversation): ResponseEntity<Conversation> {
        if (conversation.id != null) {
            return ResponseEntity(HttpStatus.BAD_REQUEST)
        }
        val savedConversation: Conversation = conversationRepository.save(conversation)
        return ResponseEntity(savedConversation, HttpStatus.OK)
    }

    @PutMapping
    fun updateCustomer(@RequestBody conversation: @Valid Conversation): ResponseEntity<Conversation> {
        if (conversation.id == null) {
            return ResponseEntity(HttpStatus.BAD_REQUEST)
        }
        val savedConversation: Conversation = conversationRepository.save(conversation)
        return ResponseEntity(savedConversation, HttpStatus.OK)
    }
}