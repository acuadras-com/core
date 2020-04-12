package com.tutendero.api.model.interfaces

import java.util.*

interface AuditableEntity {
    var createdDate: Date
    var updatedDate: Date?
}