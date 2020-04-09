package com.tutendero.api.controller

import com.tutendero.api.model.Customer
import com.tutendero.api.service.CustomerService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException
import javax.validation.Valid

@RestController
@RequestMapping("/customer")
class CustomerRestController(
        private val customerService: CustomerService
) {

    @GetMapping("/{id}")
    fun getCustomer(@PathVariable id: String): ResponseEntity<Customer> {
        val customer: Customer? = customerService.findById(id)
        return if (customer != null) {
            ResponseEntity(customer, HttpStatus.OK)
        } else ResponseEntity(HttpStatus.OK)
    }

    @PostMapping
    fun createCustomer(@RequestBody customer: @Valid Customer): ResponseEntity<Customer> {
        if (customer.id != null) {
            return ResponseEntity(HttpStatus.BAD_REQUEST)
        }
        val savedCustomer: Customer? = customerService.create(customer)
        return ResponseEntity(savedCustomer, HttpStatus.OK)
    }

    @PutMapping
    fun updateCustomer(@RequestBody customer: @Valid Customer): ResponseEntity<Customer> {
        if (customer.id == null) {
            throw ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Foo Not Found")
        }
        val savedCustomer: Customer? = customerService.create(customer)
        return ResponseEntity(savedCustomer, HttpStatus.OK)
    }

    @DeleteMapping("/{id}")
    fun deleteCustomer(@PathVariable id: String?): ResponseEntity<Customer> {
        if (id == null) {
            return ResponseEntity(HttpStatus.BAD_REQUEST)
        }
        customerService.delete(id)
        return ResponseEntity(HttpStatus.OK)
    }
}