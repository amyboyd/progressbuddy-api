package com.housingbuddy.housingbuddyapi.models

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.housingbuddy.housingbuddyapi.utils.Collections
import io.swagger.annotations.ApiModel
import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.DBRef
import org.springframework.data.mongodb.core.mapping.Document

@ApiModel
@Document(collection = Collections.COACHES_COLLECTION)
@JsonIgnoreProperties(ignoreUnknown = true)
data class Coach(
    @Indexed
    @Id
    val coachID: ObjectId = ObjectId(),
    var name: String,
    var bio: String,
    var specialities: String,
    var jobTitle: String,
    var photo: String? = "",
    @DBRef
    var clients: List<Client?> = mutableListOf(),
    @DBRef
	var events: List<Event?> = mutableListOf()
)