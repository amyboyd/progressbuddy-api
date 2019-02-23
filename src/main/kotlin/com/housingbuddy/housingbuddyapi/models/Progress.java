package com.housingbuddy.housingbuddyapi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.housingbuddy.housingbuddyapi.utils.Collections;
import io.swagger.annotations.ApiModel;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@ApiModel
@Document(collection = Collections.PROGRESS_COLLECTION)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Progress {
    @Id
    public ObjectId progressID;

    public Type type;

    private List<ProgressHistory> history;

    public List<ProgressHistory> getHistory() {
        if (history == null) {
            history = new ArrayList<>();
        }
        return history;
    }

    public enum Type {
        MOTIVATION_AND_RESPONSIBILITY,
        MONEY_MANAGEMENT,
        RELATIONSHIPS,
        SELF_CARE_AND_LIVING_SKILLS,
        DRUGS_AND_ALCOHOL,
        PHYSICAL_HEALTH,
        MENTAL_HEALTH,
        MEANINGFUL_USE_OF_TIME,
        MANAGING_TENANCY_AND_ACCOMMODATION,
        CRIMINAL_OFFENDING
    }

    public static class ProgressHistory {
        public Date date;

        public int score;

        public String comment;
    }
}
