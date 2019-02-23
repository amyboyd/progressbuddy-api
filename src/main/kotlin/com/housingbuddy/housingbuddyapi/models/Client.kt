package com.housingbuddy.housingbuddyapi.models

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.Indexed

data class Client (
	@Id
	@Indexed var clientID: String = ObjectId().toHexString(),
	@Indexed var progressID: String,
	@Indexed var coachID: String,
	var name: String,
	var password: String,
	var phone: String,
	var email: String,
	var address: String
)