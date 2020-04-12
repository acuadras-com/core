package com.tutendero.api.model

import com.tutendero.api.model.interfaces.AuditableEntity
import com.tutendero.api.model.interfaces.DisableableEntity
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.geo.GeoJsonPoint
import org.springframework.data.mongodb.core.mapping.Document
import java.util.*

@Document
class Customer(
        var demographics: Demographic
) : DisableableEntity, AuditableEntity {
    @Id
    var id: String? = null
    var coordinates: Array<Double>? = null
    var location: GeoJsonPoint? = null

    override var disabled = false
    override var createdAt: Date = Date()
    override var updatedAt: Date? = null
}