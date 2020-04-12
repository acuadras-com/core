package com.tutendero.api.model

import com.tutendero.api.model.interfaces.AuditableEntity
import com.tutendero.api.model.interfaces.DisableableEntity
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.geo.GeoJsonPoint
import org.springframework.data.mongodb.core.mapping.Document
import java.util.*

@Document
data class Customer(
        var demographics: Demographic
) : DisableableEntity, AuditableEntity {
    @Id
    var id: String? = null
    var location: GeoJsonPoint? = null

    override var disabled = false
    override var createdDate: Date = Date()
    override var updatedDate: Date? = null
}