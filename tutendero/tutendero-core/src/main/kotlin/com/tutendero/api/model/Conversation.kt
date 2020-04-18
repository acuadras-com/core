package com.tutendero.api.model

import com.tutendero.api.model.interfaces.AuditableEntity
import com.tutendero.api.model.interfaces.DisableableEntity
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field
import java.util.*

@Document
data class Conversation(
        @Field("customer_id")
        var customerId: String,
        @Field("shop_id")
        var shopId: String,
        var messages: List<Message>
) : DisableableEntity, AuditableEntity {
    @Id
    var id: String? = null

    override var disabled = false
    override var createdAt: Date = Date()
    override var updatedAt: Date? = null
}

data class ConversationDto(
        var customerId: String,
        var shopId: String,
        var messages: List<Message>,
        var id: String? = null,
        var disabled: Boolean = false,
        var createdAt: Date = Date(),
        var updatedAt: Date? = null
)

fun ConversationDto.toEntity(): Conversation {
    val conversation = Conversation(this.customerId, this.shopId, this.messages)
    conversation.id = this.id
    conversation.disabled = this.disabled
    conversation.createdAt = this.createdAt
    conversation.createdAt = this.createdAt
    return conversation
}

fun Conversation.toDto(): ConversationDto {
    return ConversationDto(
            this.customerId,
            this.shopId,
            this.messages,
            this.id,
            this.disabled,
            this.createdAt,
            this.updatedAt)
}