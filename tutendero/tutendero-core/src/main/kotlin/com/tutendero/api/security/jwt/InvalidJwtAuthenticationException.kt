package com.tutendero.api.security.jwt

import org.springframework.security.core.AuthenticationException

class InvalidJwtAuthenticationException(e: String?) : AuthenticationException(e)