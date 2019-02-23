package com.housingbuddy.housingbuddyapi.models

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "organizations")
data class Organization(
    @Indexed
    @Id
    val organizationID: ObjectId = ObjectId(),
    var photo: String
)
