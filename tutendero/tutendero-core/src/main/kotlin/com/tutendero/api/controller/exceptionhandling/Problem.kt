package com.tutendero.api.controller.exceptionhandling

data class Problem(
        val type: String,
        val title: String,
        val detail: String,
        val status: Int
)