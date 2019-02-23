package com.housingbuddy.housingbuddyapi.services

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.stereotype.Service

@Service
class AppointmentService (
	@Autowired private val mongoTemplate: MongoTemplate,
	@Autowired private val clientService: ClientService
) {

	fun createAppointment() {

	}

	fun retrieveAppointment (clientID:String) = clientService.retrieveClientByID(clientID)?.appointments


	fun updateAppointment(appointmentID: String) {

	}
}