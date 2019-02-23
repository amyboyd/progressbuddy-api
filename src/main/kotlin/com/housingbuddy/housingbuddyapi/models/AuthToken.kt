package com.housingbuddy.housingbuddyapi.models

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.DBRef
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "auth_tokens")
data class AuthToken(
    @Id
    @Indexed
    var token: ObjectId = ObjectId(),

    @DBRef
    var user: User
)