package com.housingbuddy.housingbuddyapi.models

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.Indexed

data class Coach (
	@Indexed
	@Id
	val coachID: String = ObjectId().toHexString(),
	var name: String,
	var password: String,
	var email: String,
	var bio: String,
	var specialities: String,
	var jobTitle: String,
	var photo: String? = "",
	var clientList: List<Client?> = mutableListOf()
)