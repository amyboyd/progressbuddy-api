package com.housingbuddy.housingbuddyapi.services

import com.housingbuddy.housingbuddyapi.models.Client
import com.housingbuddy.housingbuddyapi.utils.Const
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.stereotype.Service

@Service
class ClientService (@Autowired private val mongoTemplate: MongoTemplate) {

	fun registerClient() {

	}

	fun loginClient() {

	}

	fun retrieveClientInfo(clientID: String): MutableList<Client> {
		val query = Query(Criteria(Const.ID).`is`(clientID))
		return mongoTemplate.find(query, Client::class.java, Const.CLIENT_COLLECTION)
	}

}