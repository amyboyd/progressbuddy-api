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
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class ClientService (@Autowired private val mongoTemplate: MongoTemplate) {

	fun registerClient(client: Client): ResponseEntity<String> {
		val verifyQuery = Query()
			.addCriteria(
				Criteria().andOperator(
					Criteria.where(ClientFields.NAME).`is`(client.name),
					Criteria.where(ClientFields.EMAIL).`is`(client.email)
				)
			)
		return if (mongoTemplate.count(verifyQuery, Collections.CLIENTS_COLLECTION) > 0) {
			LOGGER.info("Client with name: ${client.name} and email: ${client.email} already exists")
			ResponseEntity(HttpStatus.CONFLICT)
		}
		else {
			return try {
				mongoTemplate.insert(client, Collections.CLIENTS_COLLECTION)
				LOGGER.info("Successfully inserted new client: ${client.clientID}")
				ResponseEntity(HttpStatus.OK)
			} catch (exception: Exception) {
				LOGGER.error("Failed to insert new client: ${client.clientID}")
				ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
			}
		}
	}

	fun loginClient() {

	}

	fun retrieveClientIDByEmail(email: String): Client? {
		LOGGER.info("Trying to get client by email: $email")
		val query = Query()
		query.addCriteria(Criteria.where(ClientFields.EMAIL).`is`(email))
			.fields()
			.include(Const.ID).include(ClientFields.NAME).include(ClientFields.EMAIL).include(ClientFields.PASSWORD)
			.include(ClientFields.PHONE).include(ClientFields.ADDRESS)

		return mongoTemplate.findOne(query, Client::class.java, Collections.CLIENTS_COLLECTION)
	}

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