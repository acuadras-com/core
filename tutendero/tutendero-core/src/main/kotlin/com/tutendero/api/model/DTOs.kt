package com.tutendero.api.model

import org.springframework.data.mongodb.core.geo.GeoJsonPoint
import java.util.*

data class CustomerDto(
        var demographics: Demographic,
        var id: String? = null,
        var location: GeoJsonPoint? = null,
        var disabled: Boolean = false,
        var createdDate: Date = Date(),
        var updatedDate: Date? = null
)

data class ConversationDto(
        var customerId: String,
        var shopId: String,
        var messages: List<Message>,
        var id: String? = null,
        var disabled: Boolean = false,
        var createdDate: Date = Date(),
        var updatedDate: Date? = null
)

data class ShopDto(
        var name: String,
        var phone: String,
        var id: String? = null,
        var categories: List<String>? = null,
        var photoUrl: String? = null,
        var location: GeoJsonPoint? = null,
        var demographics: Demographic? = null,
        var workingHours: List<WorkingHour>? = null,
        var disabled: Boolean = false,
        var createdDate: Date = Date(),
        var updatedDate: Date? = null
)



