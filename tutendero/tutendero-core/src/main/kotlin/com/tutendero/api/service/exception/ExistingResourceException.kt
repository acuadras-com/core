package com.tutendero.api.service.exception

class ExistingResourceException(val resource: String, override val message: String) : Exception(message)
