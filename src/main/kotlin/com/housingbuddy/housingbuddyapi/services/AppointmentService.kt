package com.housingbuddy.housingbuddyapi.services

import com.housingbuddy.housingbuddyapi.models.Appointment
import com.housingbuddy.housingbuddyapi.utils.Collections
import com.housingbuddy.housingbuddyapi.utils.Const
import org.bson.types.ObjectId
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.data.mongodb.core.query.Update
import org.springframework.stereotype.Service

@Service
class AppointmentService(
    @Autowired private val mongoTemplate: MongoTemplate,
    @Autowired private val clientService: ClientService
) {

    fun createAppointment() {

    }

    fun retrieveAppointmentByClientID(clientID: String) = clientService.retrieveClientByID(clientID)?.appointments

    fun retrieveAppointmentByID(clientID: String): Appointment? {
        LOGGER.info("Retrieving Client with ID: $clientID")
        val appt = mongoTemplate.findById(ObjectId(clientID), Appointment::class.java, Collections.APPOINTMENTS_COLLECTION)
        LOGGER.info("Appointment Retrieved! The title is: ${appt?.title}")
        return appt
    }

    fun updateAttendanceStatus(appointmentID: String, status: Appointment.Status, notAttendingReason: String?) {
        val updateQuery = Query().addCriteria(Criteria.where(Const.ID).`is`(appointmentID))
        val update = Update().set("appointmentStatus", status)
        notAttendingReason?.let {
            update.set("reasonForNotAttending", notAttendingReason)
        }
        val result = mongoTemplate.updateFirst(updateQuery, update, Collections.APPOINTMENTS_COLLECTION)
        if (result.wasAcknowledged()) {
            LOGGER.info("Updated Appointment status to $status")
        } else
            LOGGER.warn("Failed to update appointment status")
    }

    private companion object {
        val LOGGER: Logger = LoggerFactory.getLogger(AppointmentService::class.java)
    }
}
