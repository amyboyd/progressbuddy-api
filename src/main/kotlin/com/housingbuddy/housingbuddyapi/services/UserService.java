package com.housingbuddy.housingbuddyapi.services;

import com.housingbuddy.housingbuddyapi.models.User;
import com.housingbuddy.housingbuddyapi.utils.MongoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

@Service
public class UserService {
    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * Searches case-insensitively.
     */
    public User findOneByEmail(String email) {
        if (email == null || email.isEmpty()) {
            return null;
        }

        Query query = query(where("email").regex("^" + MongoUtils.escapeForRegex(email) + "$", "i"))
            .limit(1);

        return mongoTemplate.findOne(query, User.class);
    }
}
