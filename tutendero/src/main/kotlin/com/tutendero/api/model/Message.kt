package com.tutendero.api.model

import java.util.*

data class Message (
    var from: String? = null,
    var to: String? = null,
    var date: Date? = null,
    var message: String? = null
)