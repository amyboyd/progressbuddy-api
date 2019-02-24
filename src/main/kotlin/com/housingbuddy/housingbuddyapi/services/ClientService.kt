package com.housingbuddy.housingbuddyapi.services

import com.housingbuddy.housingbuddyapi.models.Client
import com.housingbuddy.housingbuddyapi.models.Event
import com.housingbuddy.housingbuddyapi.models.Progress
import com.housingbuddy.housingbuddyapi.utils.Collections
import com.mongodb.DBRef
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
        val descriptionOptions: List<String> = mutableListOf(
            "Oldham Way, Manchester",
            "Northern Quarter, Manchester",
            "Oxford Road, Manchester"
        )

        val description: String = descriptionOptions.get(Random().nextInt(descriptionOptions.size))

        val name = retrieveClientByID(clientID)?.name
        val event = Event(name = "Check-in Event", title = "$name Has Just Checked In!", bodyText = "$name has checked in at $description.", date = Date())

        mongoTemplate.insert(event, Collections.EVENTS_COLLECTION)

        mongoTemplate.updateFirst(
            Query.query(Criteria.where("_id").`is`(clientID)),
            Update.update("lastCheckedInLatitude", latitude)
                .set("lastCheckedInLongitude", longitude)
                .set("lastCheckedInDescription", description)
                .currentDate("lastCheckedInAt")
                .push("events", DBRef(Collections.EVENTS_COLLECTION, event.eventID)),
            Client::class.java
        )

        return retrieveClientByID(clientID)!!
    }

    fun recordProgressScoreByType(
        clientID: String,
        type: Progress.Type,
        score: Int,
        comment: String
    ) {
        val thisDate = Date()
        val client = retrieveClientByID(clientID)!!
        val progress = client.getProgressByType(type)

        val newHistory = Progress.ProgressHistory()
        newHistory.date = thisDate
        newHistory.score = score
        newHistory.comment = comment

        progress.history.add(newHistory)

        val name = retrieveClientByID(clientID)?.name
        val event = Event(name = "Progress Update", title = "$name Has Updated their Progress", bodyText = "$name has changed the progress of $type to $score", date = thisDate)
        mongoTemplate.save(progress)
        mongoTemplate.insert(event, Collections.EVENTS_COLLECTION)
        mongoTemplate.updateFirst(
            Query.query(Criteria.where("_id").`is`(clientID)),
            Update()
                .push("events", DBRef(Collections.EVENTS_COLLECTION, event.eventID))
                .push("progress", DBRef(Collections.PROGRESS_COLLECTION, progress.progressID)
            ), Client::class.java
        )
    }
    private companion object {
        val LOGGER: Logger = LoggerFactory.getLogger(ClientService::class.java)
    }
}
