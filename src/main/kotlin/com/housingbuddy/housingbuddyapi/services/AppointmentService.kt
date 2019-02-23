package com.housingbuddy.housingbuddyapi.services

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.stereotype.Service

@Service
class AppointmentService (@Autowired private val mongoTemplate: MongoTemplate) {

	fun createAppointment() {

	}

	fun retrieveAppointment (appointmentID:String){

	}

	fun updateAppointment(appointmentID: String) {

	}
}