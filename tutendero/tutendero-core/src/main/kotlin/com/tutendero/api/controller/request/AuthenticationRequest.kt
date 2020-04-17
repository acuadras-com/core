package com.tutendero.api.controller.request

data class AuthenticationRequest(
    val username: String,
    val password: String)