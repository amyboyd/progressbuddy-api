package com.housingbuddy.housingbuddyapi.configs;

import com.housingbuddy.housingbuddyapi.models.AuthToken;
import com.housingbuddy.housingbuddyapi.models.User;
import com.housingbuddy.housingbuddyapi.services.ActiveUserService;
import com.housingbuddy.housingbuddyapi.services.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Authenticate users via an 'Authorization' header.
 */
@Component
final public class AuthorizationHeaderFilter extends OncePerRequestFilter {
    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private ActiveUserService activeUserService;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
        throws ServletException, IOException {

        String value = request.getHeader("Authorization");
        if (value != null) {
            if (value.startsWith("User ")) {
                acceptUserAuthorizationHeader(value, response);
            } else {
                throw new SecurityException("Authorization header must start with 'User', followed by a space, then the token");
            }
        }

        filterChain.doFilter(request, response);
    }

    private void acceptUserAuthorizationHeader(String value, HttpServletResponse response) {
        String token = value.substring("User ".length());
        if (token.isEmpty()) {
            setForcedLogoutHeaders(response);
            throw new SecurityException("No token in the Authorization header");
        }

        if (token.isEmpty()) {
            return;
        }

        AuthToken tokenOption = authenticationService.findValidToken(token);

        if (tokenOption == null) {
            setForcedLogoutHeaders(response);
            throw new SecurityException("No user found with authentication token " + token);
        }

        User user = tokenOption.getUser();

        activeUserService.setAuthenticatedUser(user);
    }

    private void setForcedLogoutHeaders(HttpServletResponse response) {
        response.setHeader("Access-Control-Expose-Headers", "X-Logout");
        response.setHeader("X-Logout", "true");
    }
}
