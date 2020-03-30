package com.tutendero.api.model

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field
import java.util.*

@Document
class User(var type: String, var email: String, var password: String, var role: String) {
    @Id
    @Field("_id")
    var id: ObjectId? = null
    val key: String
        get() = id.toString()
    val creationDate: Date = Date()
    var updateDate: Date? = null
}