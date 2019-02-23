package com.housingbuddy.housingbuddyapi.models

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.housingbuddy.housingbuddyapi.utils.Collections
import io.swagger.annotations.ApiModel
import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.DBRef
import org.springframework.data.mongodb.core.mapping.Document
import java.util.*

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
    var lastCheckedInAt: Date?,
    var lastCheckedInLatitude: Double?,
    var lastCheckedInLongitude: Double?,
    var lastCheckedInDescription: String?,
//    @DBRef(lazy = true)
//    @JsonIgnore
//    var coach: Coach? = null,
    @DBRef(lazy = true)
    var appointments: List<Appointment?> = mutableListOf(),
    @DBRef(lazy = true)
    var events: List<Event?> = mutableListOf(),
    @DBRef(lazy = true)
    var progress: List<Progress?> = mutableListOf()
)
