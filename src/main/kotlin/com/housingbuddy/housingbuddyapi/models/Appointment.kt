package com.housingbuddy.housingbuddyapi.models

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.Indexed
import java.util.*

data class Appointment (
	@Indexed
	@Id
	val appointmentID: String = ObjectId().toHexString(),
	var title: String,
	var durationMinutes: Int,
	var dateTime: Date,
	var notes: String,
	var attended: Boolean,
	var reasonForNotAttending: String?,
	var appointmentType: String,
	var appointmentStatus: AppointmentStatus,
	var appointmentPriority: AppointmentPriority
)

enum class AppointmentStatus {
	NOT_SET,
	CONFIRMED_TO_ATTEND,
	ATTENDED,
	NOT_ATTENDED,
	CANCELLED
}

enum class AppointmentPriority {
	MANDATORY,
	SUGGESTED,
	OPTIONAL
}

