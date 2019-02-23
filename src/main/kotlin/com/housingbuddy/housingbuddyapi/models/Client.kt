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
@Document(collection = Collections.CLIENTS_COLLECTION)
@JsonIgnoreProperties(ignoreUnknown = true)
data class Client(
    @Id
    @Indexed
    val clientID: ObjectId = ObjectId(),
    var name: String,
    var phone: String,
    var address: String,
    var lastCheckedInAt: String,
    var lastCheckedInDescription: String,
    var lastCheckedInLatitude: String,
    var lastCheckedInLongitude: String,
    @DBRef
    var coach: Coach? = null,
    @DBRef
    var appointments: List<Appointment?> = mutableListOf(),
    @DBRef
    var progress: Progress? = null
)