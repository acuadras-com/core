package com.tutendero.api.controller.exceptionhandling

import com.tutendero.api.service.exception.ExistingResourceException
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ExistingResourceExceptionHandler {
    companion object {
        const val TYPE : String = "problems/existing_resource"
    }

    @ExceptionHandler(ExistingResourceException::class)
    @ResponseStatus(HttpStatus.OK)
    fun handleShopException(exception: ExistingResourceException): ProblemReport {
        val problem = Problem(TYPE, exception.resource, exception.message, HttpStatus.OK.value())
        return ProblemReport(listOf(problem))
    }

}
