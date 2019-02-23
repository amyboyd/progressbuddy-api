package com.housingbuddy.housingbuddyapi.controllers;

import com.housingbuddy.housingbuddyapi.controllers.dto.LoginRequest;
import com.housingbuddy.housingbuddyapi.controllers.dto.LoginResponse;
import com.housingbuddy.housingbuddyapi.controllers.dto.SelfApiResponse;
import com.housingbuddy.housingbuddyapi.models.AuthToken;
import com.housingbuddy.housingbuddyapi.models.User;
import com.housingbuddy.housingbuddyapi.services.ActiveUserService;
import com.housingbuddy.housingbuddyapi.services.AuthenticationService;
import com.housingbuddy.housingbuddyapi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@RestController
@RequestMapping(path = "/authentication", produces = "application/json; charset=utf-8")
public class AuthController {
    @Autowired
    private UserService userService;

    @Autowired
    private ActiveUserService activeUserService;

    @Autowired
    private AuthenticationService authService;

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public LoginResponse login(@RequestBody @Valid LoginRequest loginDetails, HttpServletResponse response) {
        User user = authService.login(loginDetails);

        if (user != null) {
            AuthToken authToken = authService.issueNormalLoginToken(user);
            response.setStatus(HttpServletResponse.SC_OK);
            return LoginResponse.success(
                user,
                authToken
            );
        } else {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return LoginResponse.failure();
        }
    }

    @RequestMapping(path = "/self", method = RequestMethod.GET)
    @PreAuthorize("isAuthenticated()")
    public SelfApiResponse getSelf() {
        User user = activeUserService.getUser();
        if (user == null) {
            throw new SecurityException();
        }
        SelfApiResponse response = new SelfApiResponse(user);
        return response;
    }
}
