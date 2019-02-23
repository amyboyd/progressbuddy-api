package com.housingbuddy.housingbuddyapi.services;

import com.google.common.collect.ImmutableSet;
import com.housingbuddy.housingbuddyapi.models.User;
import com.housingbuddy.housingbuddyapi.utils.MongoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * A wrapper around Spring's SecurityContextHolder, with some convenience methods added.
 */
@Service
public class ActiveUserService {
    @Autowired
    private MongoTemplate mongoTemplate;

    public void setAuthentication(Authentication auth) {
        SecurityContextHolder.getContext().setAuthentication(auth);
    }

    public void setAuthenticatedUser(User user) {
        user = MongoUtils.resolveLazyRef(user, User.class);

        Set<GrantedAuthority> grantedAuthorities = getGrantedAuthorities(user);

        Authentication token = new UsernamePasswordAuthenticationToken(user, user.getPassword(), grantedAuthorities);

        // Let Spring know the user is authenticated.
        setAuthentication(token);
    }

    public User getUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth == null) {
            return null;
        }

        Object user = auth.getPrincipal();
        if (!(user instanceof User)) {
            return null;
        }

        return (User) user;
    }

    public User getActiveUserOrThrow() {
        if (getUser() != null) {
            return getUser();
        } else {
            throw new SecurityException("User is not set");
        }
    }

    public static ImmutableSet<GrantedAuthority> getGrantedAuthorities(User user) {
        Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
        return ImmutableSet.copyOf(authorities);
    }

    public User getActiveUserOrNull() {
        User user = getUser();
        if (user == null) {
            return null;
        }

        return user;
    }

    public boolean isAuthenticated() {
        return getUser() != null;
    }
}
