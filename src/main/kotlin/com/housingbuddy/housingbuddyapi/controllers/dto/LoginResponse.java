package com.housingbuddy.housingbuddyapi.controllers.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.housingbuddy.housingbuddyapi.models.AuthToken;
import com.housingbuddy.housingbuddyapi.models.User;
import lombok.Getter;
import lombok.NonNull;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
final public class LoginResponse {
    final private boolean isLoggedIn;

    final private User user;

    final private AuthToken authToken;

    private LoginResponse(boolean isLoggedIn, User user, AuthToken authToken) {
        this.isLoggedIn = isLoggedIn;
        this.user = user;
        this.authToken = authToken;
    }

    public static LoginResponse success(@NonNull User user, @NonNull AuthToken authToken) {
        return new LoginResponse(true, user, authToken);
    }

    public static LoginResponse failure() {
        return new LoginResponse(false, null, null);
    }
}
