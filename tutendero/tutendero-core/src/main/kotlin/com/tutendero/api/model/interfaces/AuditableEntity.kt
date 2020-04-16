package com.tutendero.api.model.interfaces

import java.util.*

interface AuditableEntity {
    var createdAt: Date
    var updatedAt: Date?
}