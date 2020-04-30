package com.tutendero.email.model

data class Mail(
        var to: String,
        var subject: String
) {

    var attachments: List<Any>? = null
    var props: Map<String, Any>? = null

}