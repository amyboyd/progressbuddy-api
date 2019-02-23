package com.housingbuddy.housingbuddyapi.models

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.DBRef

data class Client(
    @Id
    @Indexed
    val clientID: ObjectId = ObjectId(),
//    @DBRef
//    var user: User,
    var name: String,
    var phone: String,
    var address: String,
    var coach: Coach? = null, //potentially nullable
    var appointments: List<Appointment?> = mutableListOf(),
    var progress: Progress? = null
)