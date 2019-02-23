package com.housingbuddy.housingbuddyapi.services

import com.housingbuddy.housingbuddyapi.models.Coach
import com.housingbuddy.housingbuddyapi.utils.Collections
import com.housingbuddy.housingbuddyapi.utils.Const
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.stereotype.Service

@Service
class CoachService (@Autowired private val mongoTemplate: MongoTemplate) {

	fun registerCoach() {

	}

	fun loginCoach() {

	}

	fun retrieveCoachInfo(coachID: String): MutableList<Coach> {
		val query = Query(Criteria(Const.ID).`is`(coachID))
		return mongoTemplate.find(query, Coach::class.java, Collections.COACHES_COLLECTION)
	}

}