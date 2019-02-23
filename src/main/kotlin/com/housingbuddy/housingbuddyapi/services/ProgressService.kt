package com.housingbuddy.housingbuddyapi.services

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.stereotype.Service

@Service
class ProgressService (@Autowired private val mongoTemplate: MongoTemplate) {
}