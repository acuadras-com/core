package com.tutendero.api.service

import com.tutendero.api.model.Shop
import org.springframework.data.geo.Distance
import org.springframework.data.geo.Point

interface ShopService {
    fun create(shop: Shop): Shop?
    fun update(shop: Shop): Shop?
    fun delete(id: String)
    fun findById(id: String): Shop?
    fun findAll(): List<Shop?>
    fun findByCategoriesIn(categories : List<String>): List<Shop?>
    fun findByLocationNear(point: Point, distance: Distance): List<Shop?>
    fun findByLocationNearAndCategoriesIn(point: Point, distance: Distance, categories: List<String>): List<Shop?>
}