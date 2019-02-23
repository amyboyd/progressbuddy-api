package com.housingbuddy.housingbuddyapi.models

import io.swagger.annotations.ApiModel
import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document

@ApiModel
@Document(collection = "organizations")
data class Organization (
	@Indexed
	@Id
	val organizationID: ObjectId = ObjectId(),
	var photo: String
)