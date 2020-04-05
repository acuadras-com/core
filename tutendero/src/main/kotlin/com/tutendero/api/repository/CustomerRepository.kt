package com.tutendero.api.repository

import com.tutendero.api.model.Customer
import org.springframework.data.mongodb.repository.MongoRepository

interface CustomerRepository: MongoRepository<Customer, String>