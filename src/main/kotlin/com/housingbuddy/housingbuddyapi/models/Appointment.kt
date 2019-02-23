package com.housingbuddy.housingbuddyapi.models

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.Indexed
import java.util.*

data class Appointment (
	@Indexed
	@Id
	var appointmentID: String = ObjectId().toHexString(),
	var title: String,
	var duration: String,
	var notes: String,
	var dateTime: Date,
	var attended: Boolean,
	var reasonForNotAttending: String,
	var appointmentStatus: AppointmentStatus
)

enum class AppointmentStatus {
	NOT_SET,
	CONFIRMED_TO_ATTEND,
	ATTENDED,
	NOT_ATTENDED,
	CANCELLED
}

