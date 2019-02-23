package com.housingbuddy.housingbuddyapi.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.housingbuddy.housingbuddyapi.utils.Collections;
import io.swagger.annotations.ApiModel;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@ApiModel
@Document(collection = Collections.COACHES_COLLECTION)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Coach {
    @Id
    public ObjectId coachID;

    public String name;

    public String bio;

    public String specialities;

    public String jobTitle;

    public String photo;

    @DBRef(lazy = true)
    @JsonIgnore
    private List<Client> clients;

    public List<Client> getClients() {
        if (clients == null) {
            clients = new ArrayList<>();
        }
        return clients;
    }
}
