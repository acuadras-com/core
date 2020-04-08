package com.tutendero.api.controller

import com.tutendero.api.model.Customer
import com.tutendero.api.repository.CustomerRepository
import org.bson.types.ObjectId
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException
import java.util.*
import javax.validation.Valid

@RestController
@RequestMapping("/customer")
class CustomerRestController(
        private val customerRepository: CustomerRepository
) {

    @GetMapping("/{id}")
    @CrossOrigin
    fun getCustomer(@PathVariable id: String?): ResponseEntity<Customer> {
        if (id == null) {
            return ResponseEntity(HttpStatus.BAD_REQUEST)
        }
        val ot: Optional<Customer> = customerRepository.findById(ObjectId(id))
        return if (ot.isPresent) {
            ResponseEntity(ot.get(), HttpStatus.OK)
        } else ResponseEntity(HttpStatus.OK)
    }

    @PostMapping
    @CrossOrigin
    fun createCustomer(@RequestBody customer: @Valid Customer): ResponseEntity<Customer> {
        if (customer.id != null) {
            return ResponseEntity(HttpStatus.BAD_REQUEST)
        }
        val savedCustomer: Customer = customerRepository.save(customer)
        return ResponseEntity(savedCustomer, HttpStatus.OK)
    }

    @PutMapping
    @CrossOrigin
    fun updateCustomer(@RequestBody customer: @Valid Customer): ResponseEntity<Customer> {
        if (customer.id == null) {
            throw ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Foo Not Found")
        }
        val savedCustomer: Customer = customerRepository.save(customer)
        return ResponseEntity(savedCustomer, HttpStatus.OK)
    }
}