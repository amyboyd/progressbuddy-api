package com.housingbuddy.housingbuddyapi.services

import com.housingbuddy.housingbuddyapi.models.Coach
import com.housingbuddy.housingbuddyapi.utils.Collections
import org.bson.types.ObjectId
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.stereotype.Service

@Service
class CoachService(@Autowired private val mongoTemplate: MongoTemplate) {

    fun retrieveCoachByID(coachID: String): Coach? {
        LOGGER.info("Retrieving Coach with ID: $coachID")
        val coach = mongoTemplate.findById(ObjectId(coachID), Coach::class.java, Collections.COACHES_COLLECTION)
        LOGGER.info("Coach name is: ${coach?.name}")
        return coach
    }

    private companion object {
        val LOGGER: Logger = LoggerFactory.getLogger(CoachService::class.java)
    }
}
