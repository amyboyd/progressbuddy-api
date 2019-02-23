package com.housingbuddy.housingbuddyapi.models;

import io.swagger.annotations.ApiModel;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@ApiModel
@Document(collection = "users")
public class User {
    @Id
    public ObjectId id;

    public String email;

    public String password;

    @DBRef
    public Coach coach;

    @DBRef
    public Client client;
}
