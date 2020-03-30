package com.tutendero.api.model

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field
import java.util.*

@Document
class Conversation {
    @Id
    @Field("_id")
    var id: ObjectId? = null
    @Field("customer_id")
    var customerId: String? = null
    @Field("shop_id")
    var shopId: String? = null
    var messages: List<Message>? = null
    val key: String
        get() = id.toString()
    val creationDate: Date = Date()
    var updateDate: Date? = null
}