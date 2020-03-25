package com.tutendero.api.repository

import com.tutendero.api.model.Customer
import org.bson.types.ObjectId
import org.springframework.data.mongodb.repository.MongoRepository

interface CustomerRepository: MongoRepository<Customer, ObjectId>