package com.housingbuddy.housingbuddyapi.controllers.dto;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;

@Data
@Accessors(chain = true)
@ToString(exclude = "password")
final public class LoginRequest {
    @NotNull
    public String email;

    @NotNull
    public String password;
}
