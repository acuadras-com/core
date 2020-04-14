package com.tutendero.api.controller.exceptionhandling

import org.springframework.http.HttpStatus

class Problem(
        val type: String,
        val title: String,
        val detail: String,
        val status: Int
)