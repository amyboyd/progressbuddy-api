package com.housingbuddy.housingbuddyapi.models

import com.housingbuddy.housingbuddyapi.utils.Collections
import io.swagger.annotations.ApiModel
import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document
import java.util.*

/**
 * Model that encompassess all client activities that the coach should be notified about and should know about
 */
@ApiModel
@Document(collection = Collections.EVENTS_COLLECTION)
data class Event (
	@Indexed
	@Id
	val eventID: ObjectId = ObjectId(),
	var name: String,
	var date: Date,
	var title: String,
	var bodyText: String
)