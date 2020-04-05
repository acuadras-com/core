package com.tutendero.api.controller

import com.tutendero.api.model.Conversation
import com.tutendero.api.service.ConversationService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/conversation")
class ConversationRestController(
        private val conversationService: ConversationService
) {
    @GetMapping("/{id}")
    fun getConversation(@PathVariable id: String?): ResponseEntity<Conversation> {
        if (id == null) {
            return ResponseEntity(HttpStatus.BAD_REQUEST)
        }
        val ot: Conversation? = conversationService.findById(id)
        return if (ot != null) {
            ResponseEntity(ot, HttpStatus.OK)
        } else ResponseEntity(HttpStatus.OK)
    }

    @PostMapping
    fun createConversation(@RequestBody conversation: @Valid Conversation): ResponseEntity<Conversation> {
        if (conversation.id != null) {
            return ResponseEntity(HttpStatus.BAD_REQUEST)
        }
        val savedConversation: Conversation? = conversationService.create(conversation)
        return ResponseEntity(savedConversation, HttpStatus.OK)
    }

    @PutMapping
    fun updateConversation(@RequestBody conversation: @Valid Conversation): ResponseEntity<Conversation> {
        if (conversation.id == null) {
            return ResponseEntity(HttpStatus.BAD_REQUEST)
        }
        val savedConversation: Conversation? = conversationService.update(conversation)
        return ResponseEntity(savedConversation, HttpStatus.OK)
    }

    @DeleteMapping("/{id}")
    fun deleteConversation(@PathVariable id: String?): ResponseEntity<Conversation> {
        if (id == null) {
            return ResponseEntity(HttpStatus.BAD_REQUEST)
        }
        conversationService.delete(id)
        return ResponseEntity(HttpStatus.OK)
    }
}