package com.tutendero.api.controller

import com.tutendero.api.controller.request.GeoNearPointAndCategoriesRequest
import com.tutendero.api.controller.request.ListData
import com.tutendero.api.model.Shop
import com.tutendero.api.service.ShopService
import org.springframework.data.geo.Distance
import org.springframework.data.geo.Metrics
import org.springframework.data.geo.Point
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/shop")
class ShopRestController(
        private val shopService: ShopService
) {

    @GetMapping("/{id}")
    fun getShop(@PathVariable id: String?): ResponseEntity<Shop> {
        if (id == null) {
            return ResponseEntity(HttpStatus.BAD_REQUEST)
        }
        val shop: Shop? = shopService.findById(id)
        return if (shop != null) {
            ResponseEntity(shop, HttpStatus.OK)
        } else ResponseEntity(HttpStatus.OK)
    }

    @PostMapping
    fun createShop(@RequestBody shop: @Valid Shop): ResponseEntity<Shop> {
        if (shop.id != null) {
            return ResponseEntity(HttpStatus.BAD_REQUEST)
        }
        val savedShop: Shop? = shopService.create(shop)
        return ResponseEntity(savedShop, HttpStatus.OK)
    }

    @PutMapping
    fun updateShop(@RequestBody shop: @Valid Shop): ResponseEntity<Shop> {
        if (shop.id == null) {
            return ResponseEntity(HttpStatus.BAD_REQUEST)
        }
        val savedShop: Shop? = shopService.update(shop)
        return ResponseEntity(savedShop, HttpStatus.OK)
    }

    @DeleteMapping("/{id}")
    fun deleteShop(@PathVariable id: String?): ResponseEntity<Shop> {
        if (id == null) {
            return ResponseEntity(HttpStatus.BAD_REQUEST)
        }
        shopService.delete(id)
        return ResponseEntity(HttpStatus.OK)
    }

    @GetMapping()
    fun getShops(): ResponseEntity<List<Shop?>> {
        val shops: List<Shop?> = shopService.findAll()
        return ResponseEntity(shops, HttpStatus.OK)
    }

    @GetMapping("/categories")
    fun getShopsByCategories(@RequestBody categories: ListData): ResponseEntity<List<Shop?>> {
        val shops: List<Shop?> = shopService.findByCategoriesIn(categories.values)
        return ResponseEntity(shops, HttpStatus.OK)
    }

    @GetMapping("/geo/near/{radius}")
    fun getShopsByLocationNear(@RequestBody point: Point, @PathVariable radius: Int): ResponseEntity<List<Shop?>> {
        val shops: List<Shop?> = shopService.findByLocationNear(point, Distance(radius.toDouble(), Metrics.KILOMETERS))
        return ResponseEntity(shops, HttpStatus.OK)
    }

    @GetMapping("/geo/near/{radius}/categories")
    fun getShopsByCategoriesGeo(@RequestBody request: GeoNearPointAndCategoriesRequest, @PathVariable radius: Int): ResponseEntity<List<Shop?>> {
        val shops: List<Shop?> = shopService.findByLocationNearAndCategoriesIn(request.point, Distance(radius.toDouble(), Metrics.KILOMETERS), request.categories)
        return ResponseEntity(shops, HttpStatus.OK)
    }
}