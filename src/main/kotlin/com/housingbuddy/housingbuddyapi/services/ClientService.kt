package com.housingbuddy.housingbuddyapi.services

import com.housingbuddy.housingbuddyapi.models.Client
import com.housingbuddy.housingbuddyapi.utils.ClientFields
import com.housingbuddy.housingbuddyapi.utils.Collections
import com.housingbuddy.housingbuddyapi.utils.Const
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.stereotype.Service

@Service
class ClientService(@Autowired private val mongoTemplate: MongoTemplate) {
    fun retrieveClientByID(clientID: String): Client? {
        val query = Query()
        query.addCriteria(Criteria.where(Const.ID).`is`(clientID))
            .fields()
            .include(Const.ID).include(ClientFields.NAME).include(ClientFields.EMAIL).include(ClientFields.PASSWORD)
            .include(ClientFields.PHONE).include(ClientFields.ADDRESS)

        return mongoTemplate.findOne(query, Client::class.java, Collections.CLIENTS_COLLECTION)
    }

    private companion object {
        val LOGGER: Logger = LoggerFactory.getLogger(ClientService::class.java)
    }
}