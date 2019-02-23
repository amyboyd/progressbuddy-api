package com.housingbuddy.housingbuddyapi.models

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.Indexed

data class Progress (
	@Indexed
	@Id
	var progressID: String = ObjectId().toHexString(),
	var motivationAndResponsibility: String,
	var moneyManagement: String,
	var relationships: String,
	var selfCareAndLivingSkills: String,
	var drugsAndAlcohol: String,
	var physicalHealth: String,
	var mentalHealth: String,
	var meaningfulUseOfTime: String,
	var managingTenanacyAndAccommodation: String,
	var criminalOffending: String
)