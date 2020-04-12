package com.tutendero.api.service.impl

import com.tutendero.api.model.Customer
import com.tutendero.api.repository.CustomerRepository
import com.tutendero.api.service.CustomerService
import org.bson.types.ObjectId
import org.springframework.data.mongodb.core.geo.GeoJsonPoint
import org.springframework.stereotype.Service
import java.util.*

@Service
class CustomerServiceImpl(
        private val customerRepository: CustomerRepository
) : CustomerService {

    override fun create(customer: Customer): Customer? {
        if (customer.id == null) {
            setLocation(customer)
            customer.createdAt = Date()
            return customerRepository.save(customer)
        }
        return null
    }

    override fun update(customer: Customer): Customer? {
        if (customer.id != null) {
            setLocation(customer)
            customer.updatedAt = Date()
            return customerRepository.save(customer)
        }
        return null
    }

    override fun delete(id: String) {
        val optionalCustomer = customerRepository.findById(id)
        optionalCustomer.ifPresent { item: Customer ->
            item.disabled = true
            item.updatedAt = Date()
            customerRepository.save(item)
        }
    }

    override fun findById(id: String): Customer? {
        val os = customerRepository.findById(id)
        return os.orElse(null)
    }

    private fun setLocation(customer: Customer) {
        customer.coordinates?.let {
            if (customer.coordinates!!.size == 2) {
                val location = GeoJsonPoint(it[1], it[0])
                customer.location = location
            }
        }
    }

}