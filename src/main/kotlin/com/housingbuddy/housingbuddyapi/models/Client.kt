package com.housingbuddy.housingbuddyapi.models

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.Indexed

data class Client (
	@Id
	@Indexed val clientID: String = ObjectId().toHexString(),
	var email: String,
	var password: String,
	var name: String,
	var phone: String,
	var address: String,
	var coach: Coach? = null, //potentially nullable
	var appointments: List<Appointment?> = mutableListOf(),
	var progress: Progress? = null
)