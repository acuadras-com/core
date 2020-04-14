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
    var coordinates: Array<Double>? = null
    var location: GeoJsonPoint? = null

    override var disabled = false
    override var createdAt: Date = Date()
    override var updatedAt: Date? = null
}

data class CustomerDto(
        var demographics: Demographic,
        var id: String? = null,
        var coordinates: Array<Double>? = null,
        var location: GeoJsonPoint? = null,
        var disabled: Boolean = false,
        var createdAt: Date = Date(),
        var updatedAt: Date? = null
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as CustomerDto

        if (demographics != other.demographics) return false
        if (id != other.id) return false
        if (coordinates != null) {
            if (other.coordinates == null) return false
            if (!coordinates!!.contentEquals(other.coordinates!!)) return false
        } else if (other.coordinates != null) return false
        if (location != other.location) return false
        if (disabled != other.disabled) return false
        if (createdAt != other.createdAt) return false
        if (updatedAt != other.updatedAt) return false

        return true
    }

    override fun hashCode(): Int {
        var result = demographics.hashCode()
        result = 31 * result + (id?.hashCode() ?: 0)
        result = 31 * result + (coordinates?.contentHashCode() ?: 0)
        result = 31 * result + (location?.hashCode() ?: 0)
        result = 31 * result + disabled.hashCode()
        result = 31 * result + createdAt.hashCode()
        result = 31 * result + (updatedAt?.hashCode() ?: 0)
        return result
    }
}

fun CustomerDto.toEntity(): Customer {
    val customer = Customer(this.demographics)
    customer.id = this.id
    customer.createdAt = this.createdAt
    customer.disabled = this.disabled
    customer.location = this.location
    return customer
}

fun Customer.toDto(): CustomerDto {
    return CustomerDto(
            this.demographics,
            this.id,
            this.coordinates,
            this.location,
            this.disabled,
            this.createdAt,
            this.updatedAt)
}