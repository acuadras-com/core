package com.tutendero.api.model

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.geo.GeoJsonPoint
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field
import java.util.*
import javax.validation.constraints.Size

@Document
class Shop(var name: String, var phone: String, @field:Size(min = 1) var categories: List<String>) {
    @Id
    @Field("_id")
    var id: ObjectId? = null
    var photoUrl: String? = null
    var location: GeoJsonPoint? = null
    var demographics: Demographic? = null
    var workingHours: List<WorkingHour>? = null
    val key: String
        get() = id.toString()
    val creationDate: Date = Date()
    var updateDate: Date? = null
}