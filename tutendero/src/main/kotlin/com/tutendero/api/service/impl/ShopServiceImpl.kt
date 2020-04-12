package com.tutendero.api.service.impl

import com.tutendero.api.model.Customer
import com.tutendero.api.model.Shop
import com.tutendero.api.repository.ShopRepository
import com.tutendero.api.service.ShopService
import com.tutendero.email.service.EmailService
import org.springframework.data.geo.Distance
import org.springframework.data.geo.Point
import org.springframework.data.mongodb.core.geo.GeoJsonPoint
import org.springframework.stereotype.Service
import java.util.*

@Service
class ShopServiceImpl(
        private val shopRepository: ShopRepository,
        private val emailService: EmailService
) : ShopService {

    override fun create(shop: Shop): Shop? {
        if (shop.id == null) {
            setLocation(shop)
            shop.createdAt = Date()
            emailService.sendEmail("tutendero.startup@gmail.com",
                    "Nuevo Registro Shop",shop.toString())
            return shopRepository.save(shop)
        }
        return null
    }

    override fun update(shop: Shop): Shop? {
        if (shop.id != null) {
            setLocation(shop)
            shop.updatedAt = Date()
            return shopRepository.save(shop)
        }
        return null
    }

    override fun delete(id: String) {
        val optionalShop = shopRepository.findById(id)
        optionalShop.ifPresent { item: Shop ->
            item.disabled = true
            item.updatedAt = Date()
            shopRepository.save(item)
        }
    }

    override fun findById(id: String): Shop? {
        val os = shopRepository.findById(id)
        return os.orElse(null)
    }

    override fun findAll(): List<Shop?> {
        return shopRepository.findAll()
    }

    override fun findByCategoriesIn(categories: List<String>): List<Shop?> {
        return shopRepository.findByCategoriesIn(categories)
    }


    override fun findByLocationNear(point: Point, distance: Distance): List<Shop?> {
        return shopRepository.findByLocationNear(point, distance)
    }

    override fun findByLocationNearAndCategoriesIn(point: Point, distance: Distance, categories: List<String>): List<Shop?> {
        return shopRepository.findByLocationNearAndCategoriesIn(point, distance, categories)
    }

    private fun setLocation(shop: Shop) {
        shop.coordinates?.let {
            if (shop.coordinates!!.size == 2) {
                val location = GeoJsonPoint(it[1], it[0])
                shop.location = location
            }
        }
    }
}