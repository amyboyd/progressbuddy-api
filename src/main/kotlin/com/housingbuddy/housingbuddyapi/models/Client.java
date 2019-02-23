package com.housingbuddy.housingbuddyapi.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.housingbuddy.housingbuddyapi.utils.Collections;
import io.swagger.annotations.ApiModel;
import lombok.NonNull;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@ApiModel
@Document(collection = Collections.CLIENTS_COLLECTION)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Client {
    @Id
    public ObjectId clientID;

    public String name;

    public String phone;

    public String address;

    public Date lastCheckedInAt;

    public Double lastCheckedInLatitude;

    public Double lastCheckedInLongitude;

    public String lastCheckedInDescription;

    @DBRef
    public Coach coach;

    @DBRef(lazy = true)
    @JsonIgnore
    private List<Appointment> appointments;

    @DBRef(lazy = true)
    @JsonIgnore
    private List<Event> events;

    @DBRef(lazy = true)
    @JsonIgnore
    private List<Progress> progress;

    public List<Appointment> getAppointments() {
        if (appointments == null) {
            appointments = new ArrayList<>();
        }
        return appointments;
    }

    public List<Event> getEvents() {
        if (events == null) {
            events = new ArrayList<>();
        }
        return events;
    }

    public List<Progress> getProgress() {
        if (progress == null) {
            progress = new ArrayList<>();
        }
        return progress;
    }

    @NonNull
    public Progress getProgressByType(@NonNull ProgressType type) {
        return getProgress()
            .stream()
            .filter(p -> p.getProgressType() == type)
            .findFirst()
            .orElse(new Progress(new ObjectId(), type, new ArrayList<>()));
    }

    public Integer getLatestProgressScoreByType(@NonNull ProgressType type) {
        Progress progress = getProgressByType(type);

        if (progress.getProgressHistoryList().isEmpty()) {
            return null;
        }

        return progress
            .getProgressHistoryList()
            .get(progress.getProgressHistoryList().size() - 1)
            .getScore();
    }
}
