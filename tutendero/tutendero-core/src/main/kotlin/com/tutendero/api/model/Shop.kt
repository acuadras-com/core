package com.tutendero.api.model

import com.tutendero.api.model.interfaces.AuditableEntity
import com.tutendero.api.model.interfaces.DisableableEntity
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.geo.GeoJsonPoint
import org.springframework.data.mongodb.core.mapping.Document
import java.util.*

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

data class ShopDto(
        var name: String,
        var phone: String,
        var id: String? = null,
        var categories: List<String>? = null,
        var photoUrl: String? = null,
        var coordinates: Array<Double>? = null,
        var location: GeoJsonPoint? = null,
        var demographics: Demographic? = null,
        var workingHours: List<WorkingHour>? = null,
        var disabled: Boolean = false,
        var createdAt: Date = Date(),
        var updatedAt: Date? = null
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as ShopDto

        if (name != other.name) return false
        if (phone != other.phone) return false
        if (id != other.id) return false
        if (categories != other.categories) return false
        if (photoUrl != other.photoUrl) return false
        if (coordinates != null) {
            if (other.coordinates == null) return false
            if (!coordinates!!.contentEquals(other.coordinates!!)) return false
        } else if (other.coordinates != null) return false
        if (location != other.location) return false
        if (demographics != other.demographics) return false
        if (workingHours != other.workingHours) return false
        if (disabled != other.disabled) return false
        if (createdAt != other.createdAt) return false
        if (updatedAt != other.updatedAt) return false

        return true
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + phone.hashCode()
        result = 31 * result + (id?.hashCode() ?: 0)
        result = 31 * result + (categories?.hashCode() ?: 0)
        result = 31 * result + (photoUrl?.hashCode() ?: 0)
        result = 31 * result + (coordinates?.contentHashCode() ?: 0)
        result = 31 * result + (location?.hashCode() ?: 0)
        result = 31 * result + (demographics?.hashCode() ?: 0)
        result = 31 * result + (workingHours?.hashCode() ?: 0)
        result = 31 * result + disabled.hashCode()
        result = 31 * result + createdAt.hashCode()
        result = 31 * result + (updatedAt?.hashCode() ?: 0)
        return result
    }
}

fun ShopDto.toEntity(): Shop {
    val shop = Shop(this.name, this.phone)

    shop.id = this.id
    shop.categories = this.categories
    shop.photoUrl = this.photoUrl
    shop.coordinates  = this.coordinates
    shop.location  = this.location
    shop.demographics  = this.demographics
    shop.workingHours  = this.workingHours

    shop.disabled = this.disabled
    shop.createdAt = this.createdAt
    shop.updatedAt = this.updatedAt
    return shop
}

fun Shop.toDto(): ShopDto {
    return ShopDto(
            this.name,
            this.phone,
            this.id,
            this.categories,
            this.photoUrl,
            this.coordinates,
            this.location,
            this.demographics,
            this.workingHours,
            this.disabled,
            this.createdAt,
            this.updatedAt
    )
}