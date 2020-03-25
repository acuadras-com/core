package com.tutendero.api.repository

import com.tutendero.api.model.Shop
import org.bson.types.ObjectId
import org.springframework.data.mongodb.repository.MongoRepository

interface ShopRepository: MongoRepository<Shop, ObjectId>