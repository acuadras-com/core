package com.tutendero.api.model

import com.tutendero.api.model.interfaces.AuditableEntity
import com.tutendero.api.model.interfaces.DisableableEntity
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.util.*

@Document
class User(
        var type: String,
        var username: String,
        var password: String,
        var roles: List<String>
) : DisableableEntity, AuditableEntity {
    @Id
    var id: String? = null

    override var disabled = false
    override var createdDate: Date = Date()
    override var updatedDate: Date? = null
}