package com.tutendero.api.repository

import com.tutendero.api.model.Conversation
import org.bson.types.ObjectId
import org.springframework.data.mongodb.repository.MongoRepository

interface ConversationRepository: MongoRepository<Conversation, ObjectId>