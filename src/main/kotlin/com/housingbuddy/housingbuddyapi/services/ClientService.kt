package com.housingbuddy.housingbuddyapi.services

import com.housingbuddy.housingbuddyapi.models.Client
import com.housingbuddy.housingbuddyapi.utils.Collections
import org.bson.types.ObjectId
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.data.mongodb.core.query.Update
import org.springframework.stereotype.Service
import java.util.*


@Service
class ClientService(@Autowired private val mongoTemplate: MongoTemplate) {
    fun retrieveClientByID(clientID: String): Client? {
        LOGGER.info("Retrieving Client with ID: $clientID")
        val client = mongoTemplate.findById(ObjectId(clientID), Client::class.java, Collections.CLIENTS_COLLECTION)
        LOGGER.info("Client name is: ${client?.name}")
        LOGGER.info("Coach name is: ${client?.coach?.name}")
        return client
    }

    fun checkIn(clientID: String, latitude: Double, longitude: Double): Client {
        var descriptionOptions: List<String> = mutableListOf(
            "Oldham Way, Manchester",
            "Northern Quarter, Manchester",
            "Oxford Road, Manchester"
        )

        var description: String = descriptionOptions.get(Random().nextInt(descriptionOptions.size))

        mongoTemplate.updateFirst(
            Query.query(Criteria.where("_id").`is`(clientID)),
            Update.update("lastCheckedInLatitude", latitude)
                .set("lastCheckedInLongitude", longitude)
                .set("lastCheckedInDescription", description)
                .currentDate("lastCheckedInAt"),
            Client::class.java
        )

        return retrieveClientByID(clientID)!!
    }

    private companion object {
        val LOGGER: Logger = LoggerFactory.getLogger(ClientService::class.java)
    }
}
