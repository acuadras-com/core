package com.tutendero.api.service

import com.tutendero.api.model.Customer

interface CustomerService {
    fun create(customer: Customer): Customer?
    fun update(customer: Customer): Customer?
    fun delete(id: String)
    fun findById(id: String): Customer?
}