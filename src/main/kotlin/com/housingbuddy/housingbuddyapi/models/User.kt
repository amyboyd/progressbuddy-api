package com.housingbuddy.housingbuddyapi.models

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.DBRef

data class User(
    @Id
    @Indexed val id: ObjectId = ObjectId(),
    var email: String,
    var password: String,
    @DBRef
    var coach: Coach?,
    @DBRef
    var client: Client?
)