package com.tutendero.api.repository

import com.tutendero.api.model.Shop
import org.springframework.data.mongodb.repository.MongoRepository


interface ShopRepository: MongoRepository<Shop, String> {
    fun findByCategoriesIn(categories: List<String>): List<Shop?>
}