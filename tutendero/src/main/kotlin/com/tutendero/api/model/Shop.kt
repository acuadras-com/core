package com.tutendero.api.model

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.geo.GeoJsonPoint
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field
import javax.validation.constraints.NotBlank

@Document
class Shop {
    @Id
    @Field("_id")
    var id: ObjectId? = null
    var name: @NotBlank(message = "name is required") String? = null
    var phone: @NotBlank(message = "phone is required") String? = null
    var siteUrl: String? = null
    var photoUrl: String? = null
    var location: GeoJsonPoint? = null
    var demographics: Demographic? = null
    var categories: List<String>? = null
    val key: String
        get() = id.toString()
}