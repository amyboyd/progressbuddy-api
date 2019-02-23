package com.housingbuddy.housingbuddyapi.models

import com.housingbuddy.housingbuddyapi.utils.Collections
import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.DBRef
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = Collections.COACHES_COLLECTION)
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
    var clientList: List<Client?> = mutableListOf()
)