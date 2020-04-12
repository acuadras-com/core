package com.tutendero.api.model

import com.tutendero.api.model.interfaces.AuditableEntity
import com.tutendero.api.model.interfaces.DisableableEntity
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field
import java.util.*

@Document
class User(
        var name: String,
        var username: String,
        var password: String,
        var roles: List<String>
) : DisableableEntity, AuditableEntity {
    @Id
    var id: String? = null
    var phone: String? = null
    @Field("customer_id")
    var customerId: String? = null
    @Field("shops_ids")
    var shopsIds: List<String?> = mutableListOf<String>()
    var acceptedTermsAndConditionsAt: Date? = null
    var termsAndConditionsVersion: String? = null

    override var disabled = false
    override var createdAt: Date = Date()
    override var updatedAt: Date? = null
}