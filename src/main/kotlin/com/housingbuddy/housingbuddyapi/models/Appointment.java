package com.housingbuddy.housingbuddyapi.models;

import com.housingbuddy.housingbuddyapi.utils.Collections;
import io.swagger.annotations.ApiModel;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@ApiModel
@Document(collection = Collections.APPOINTMENTS_COLLECTION)
public class Appointment {
    @Id
    public ObjectId appointmentID;

    public String title;

    public int durationMinutes;

    public Date dateTime;

    public String notes;

    public boolean attended;

    public String reasonForNotAttending;

    public String imageURL;

    public String appointmentType;

    public Status appointmentStatus;

    public Priority appointmentPriority;

    public enum Status {
        NOT_SET,
        CONFIRMED_TO_ATTEND,
        ATTENDED,
        NOT_ATTENDED,
        CANCELLED
    }

    public enum Priority {
        MANDATORY,
        SUGGESTED,
        OPTIONAL
    }
}
