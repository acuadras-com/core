package com.tutendero.api.security.jwt

import org.springframework.security.core.AuthenticationException

class InvalidJwtAuthenticationException(e: String?) : AuthenticationException(e) {
    companion object {
        /**
         *
         */
        private const val serialVersionUID = -761503632186596342L
    }
}