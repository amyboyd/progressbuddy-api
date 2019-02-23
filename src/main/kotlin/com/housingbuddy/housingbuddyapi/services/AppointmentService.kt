package com.housingbuddy.housingbuddyapi.services

import com.housingbuddy.housingbuddyapi.models.Appointment
import com.housingbuddy.housingbuddyapi.utils.Collections
import org.bson.types.ObjectId
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.stereotype.Service

@Service
class AppointmentService(
    @Autowired private val mongoTemplate: MongoTemplate,
    @Autowired private val clientService: ClientService
) {

    fun createAppointment() {

    }

    fun retrieveAppointment(clientID: String) = clientService.retrieveClientByID(clientID)?.appointments

    fun retrieveAppointmentByID(clientID: String): Appointment? {
        LOGGER.info("Retrieving Client with ID: $clientID")
        val appt = mongoTemplate.findById(ObjectId(clientID), Appointment::class.java, Collections.APPOINTMENTS_COLLECTION)
        LOGGER.info("Appointment Retrieved! The title is: ${appt?.title}")
        return appt
    }


    fun updateAppointment(appointmentID: String) {

    }

    private companion object {
        val LOGGER: Logger = LoggerFactory.getLogger(AppointmentService::class.java)
    }
}
