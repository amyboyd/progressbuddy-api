package com.housingbuddy.housingbuddyapi.models

import com.housingbuddy.housingbuddyapi.utils.Collections
import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = Collections.PROGRESS_COLLECTION)
data class Progress (
	@Indexed
	@Id
	val progressID: ObjectId = ObjectId(),
	var motivationAndResponsibility: String,
	var moneyManagement: String,
	var relationships: String,
	var selfCareAndLivingSkills: String,
	var drugsAndAlcohol: String,
	var physicalHealth: String,
	var mentalHealth: String,
	var meaningfulUseOfTime: String,
	var managingTenancyAndAccommodation: String,
	var criminalOffending: String
)