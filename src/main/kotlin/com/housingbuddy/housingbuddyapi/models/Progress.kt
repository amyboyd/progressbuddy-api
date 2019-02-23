package com.housingbuddy.housingbuddyapi.models

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import com.housingbuddy.housingbuddyapi.utils.Collections
import io.swagger.annotations.ApiModel
import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field
import java.util.Date

@ApiModel
@Document(collection = Collections.PROGRESS_COLLECTION)
@JsonIgnoreProperties(ignoreUnknown = true)
data class Progress (
	@Indexed
	@Id
	val progressID: ObjectId = ObjectId(),
	@Field("type")
	@JsonProperty("type", required = true)
	var progressType: ProgressType,
	@Field("history")
	@JsonProperty("history", required = true)
	var progressHistoryList: List<ProgressHistory?> = mutableListOf()
)
enum class ProgressType {
	MOTIVATION_AND_RESPONSIBILITY,
	MONEY_MANAGEMENT,
	RELATIONSHIPS,
	SELF_CARE_AND_LIVING_SKILLS,
	DRUGS_AND_ALCOHOL,
	PHYSICAL_HEALTH,
	MENTAL_HEALTH,
	MEANINGFUL_USE_OF_TIME,
	MANAGING_TENANCY_AND_ACCOMMODATION,
	CRIMINAL_OFFENDING
}

data class ProgressHistory (
	var date: Date,
	var score: Int,
	var comment: String
)