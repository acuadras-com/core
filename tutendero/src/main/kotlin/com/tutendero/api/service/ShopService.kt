package com.tutendero.api.service

import com.tutendero.api.model.Shop

interface ShopService {
    fun create(shop: Shop): Shop?
    fun update(shop: Shop): Shop?
    fun delete(id: String)
    fun findById(id: String): Shop?
    fun findAll(): List<Shop?>
    fun findByCategoriesIn(categories : List<String>): List<Shop?>
}