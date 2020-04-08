package com.tutendero.api.controller

import com.tutendero.api.model.Shop
import com.tutendero.api.repository.ShopRepository
import org.bson.types.ObjectId
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*
import javax.validation.Valid

@RestController
@RequestMapping("/shop")
class ShopRestController(private val shopRepository: ShopRepository) {

    @GetMapping("/{id}")
    @CrossOrigin
    fun getShop(@PathVariable id: String?): ResponseEntity<Shop> {
        if (id == null) {
            return ResponseEntity(HttpStatus.BAD_REQUEST)
        }
        val ot: Optional<Shop> = shopRepository.findById(ObjectId(id))
        return if (ot.isPresent) {
            ResponseEntity(ot.get(), HttpStatus.OK)
        } else ResponseEntity(HttpStatus.OK)
    }

    @PostMapping
    @CrossOrigin
    fun createShop(@RequestBody shop: @Valid Shop): ResponseEntity<Shop> {
        if (shop.id != null) {
            return ResponseEntity(HttpStatus.BAD_REQUEST)
        }
        val savedShop: Shop = shopRepository.save(shop)
        return ResponseEntity(savedShop, HttpStatus.OK)
    }

    @PutMapping
    @CrossOrigin
    fun updateCustomer(@RequestBody shop: @Valid Shop): ResponseEntity<Shop> {
        if (shop.id == null) {
            return ResponseEntity(HttpStatus.BAD_REQUEST)
        }
        val savedShop: Shop = shopRepository.save(shop)
        return ResponseEntity(savedShop, HttpStatus.OK)
    }
}