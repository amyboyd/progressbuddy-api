package com.housingbuddy.housingbuddyapi.models

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "coaches")
data class Coach(
    @Indexed
    @Id
    val coachID: ObjectId = ObjectId(),
    var name: String,
    var bio: String,
    var specialities: String,
    var jobTitle: String,
    var photo: String? = "",
    var clientList: List<Client?> = mutableListOf()
)