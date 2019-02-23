package com.housingbuddy.housingbuddyapi.controllers.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.housingbuddy.housingbuddyapi.models.Client;
import com.housingbuddy.housingbuddyapi.models.Coach;
import com.housingbuddy.housingbuddyapi.models.User;
import lombok.Getter;
import lombok.NonNull;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SelfApiResponse {
    private User user;

    private Coach coach;

    private Client client;

    public SelfApiResponse(@NonNull User user) {
        this.user = user;
        this.coach = user.coach;
        this.client = user.client;
    }
}
