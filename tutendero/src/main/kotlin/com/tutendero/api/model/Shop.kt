package com.tutendero.api.model

import com.tutendero.api.model.interfaces.AuditableEntity
import com.tutendero.api.model.interfaces.DisableableEntity
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.geo.GeoJsonPoint
import org.springframework.data.mongodb.core.mapping.Document
import java.util.*
import javax.validation.constraints.Size

@Document
data class Shop(
        var name: String,
        var phone: String
) : DisableableEntity, AuditableEntity {
    @Id
    var id: String? = null
    var categories: List<String>? = null
    var photoUrl: String? = null
    var coordinates: Array<Double>? = null
    var location: GeoJsonPoint? = null
    var demographics: Demographic? = null
    var workingHours: List<WorkingHour>? = null

    override var disabled = true
    override var createdAt: Date = Date()
    override var updatedAt: Date? = null
}
