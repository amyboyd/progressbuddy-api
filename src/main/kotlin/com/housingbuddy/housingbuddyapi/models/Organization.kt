package com.housingbuddy.housingbuddyapi.models

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.Indexed

data class Organization (
	@Indexed
	@Id
	val organizationID: String = ObjectId().toHexString(),
	var photo: String
)