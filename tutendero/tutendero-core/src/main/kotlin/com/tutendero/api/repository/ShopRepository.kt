package com.tutendero.api.repository

import com.tutendero.api.model.Shop
import org.springframework.data.geo.Distance
import org.springframework.data.geo.Point
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface ShopRepository: MongoRepository<Shop, String> {
    fun findByCategoriesIn(categories: List<String>): List<Shop?>
    fun findByLocationNear(point: Point, distance: Distance): List<Shop?>
    fun findByLocationNearAndCategoriesIn(point: Point, distance: Distance, categories: List<String>): List<Shop?>
}