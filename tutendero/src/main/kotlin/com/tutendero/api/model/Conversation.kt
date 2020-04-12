package com.tutendero.api.model

import com.tutendero.api.model.interfaces.AuditableEntity
import com.tutendero.api.model.interfaces.DisableableEntity
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field
import java.util.*

@Document
class Conversation(
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