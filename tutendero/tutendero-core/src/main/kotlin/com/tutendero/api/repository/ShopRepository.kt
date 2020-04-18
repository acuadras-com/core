package com.tutendero.api.repository

import com.tutendero.api.model.Shop
import org.springframework.data.geo.Distance
import org.springframework.data.geo.Point
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface ShopRepository: MongoRepository<Shop, String> {
    fun findByNameAndPhone(name: String, phone: String): List<Shop?>
    fun findByDisabledFalseAndCategoriesIn(categories: List<String>): List<Shop?>
    fun findByDisabledFalseAndLocationNear(point: Point, distance: Distance): List<Shop?>
    fun findByDisabledFalseAndLocationNearAndCategoriesIn(point: Point, distance: Distance, categories: List<String>): List<Shop?>
    fun findByDisabledTrue(): List<Shop?>
    fun findByDisabledFalse(): List<Shop?>
}