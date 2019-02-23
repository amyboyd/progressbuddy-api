package com.housingbuddy.housingbuddyapi.services

import com.housingbuddy.housingbuddyapi.controllers.dto.LoginRequest
import com.housingbuddy.housingbuddyapi.models.AuthToken
import com.housingbuddy.housingbuddyapi.models.User
import org.bson.types.ObjectId
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.stereotype.Component

@Component
class AuthenticationService(
    @Autowired private val clientService: ClientService,
    @Autowired private val mongoTemplate: MongoTemplate,
    @Autowired private val activeUserService: ActiveUserService,
    @Autowired private val userService: UserService
) {
    fun issueNormalLoginToken(user: User): AuthToken {
        val token = AuthToken(user = user, token = ObjectId())
        mongoTemplate.insert(token)

        LOGGER.info("Issued normal authentication token {} to {}", token.token, user)

        return token
    }

    /**
     * Returns a token document represented by the given string.
     */
    fun findValidToken(token: String?): AuthToken? {
        if (token == null || token.isEmpty()) {
            throw IllegalArgumentException("Token must not be empty/null")
        }

        val found = mongoTemplate.findById(token, AuthToken::class.java)

        if (found == null) {
            LOGGER.warn("Token not found: {}", token)
            return null
        }

        return found
    }

    fun login(details: LoginRequest): User? {
        if (details.email == null || details.email.isEmpty()) {
            LOGGER.error("No email address was given")
            return null
        }

        val user: User? = userService.findOneByEmail(details.email)

        if (user == null) {
            LOGGER.error("User not found with email address")
            return null
        }

        if (!user.password.equals(details.password)) {
            LOGGER.error("Password is not correct")
            return null
        }

        activeUserService.setAuthenticatedUser(user)

        return user
    }

    private companion object {
        val LOGGER: Logger = LoggerFactory.getLogger(AuthenticationService::class.java)
    }
}

