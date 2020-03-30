package com.tutendero.api.model

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.geo.GeoJsonPoint
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field
import java.util.*

@Document
class Customer(
        var name: String,
        var phone: String,
        var demographics: Demographic
) {
    @Id
    @Field("_id")
    var id: ObjectId? = null
    var location: GeoJsonPoint? = null
    val key: String
        get() = id.toString()
    val creationDate: Date = Date()
    var updateDate: Date? = null
}