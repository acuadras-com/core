package com.tutendero.api.service.impl

import com.tutendero.api.model.Shop
import com.tutendero.api.repository.ShopRepository
import com.tutendero.api.service.ShopService
import org.springframework.stereotype.Service
import java.util.*

@Service
class ShopServiceImpl(private val shopRepository: ShopRepository) : ShopService {
    override fun create(shop: Shop): Shop? {
        if (shop.id == null) {
            shop.createdDate = Date()
            return shopRepository.save(shop)
        }
        return null
    }

    override fun update(shop: Shop): Shop? {
        if (shop.id != null) {
            shop.updatedDate = Date()
            return shopRepository.save(shop)
        }
        return null
    }

    override fun delete(id: String) {
        val optionalShop = shopRepository.findById(id)
        optionalShop.ifPresent { item: Shop ->
            item.disabled = true
            item.updatedDate = Date()
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

}