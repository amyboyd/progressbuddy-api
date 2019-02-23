package com.housingbuddy.housingbuddyapi.utils

object Const {
	const val ID = "_id"
}

object Collections {
	const val CLIENT_COLLECTION = "clientCollection"
	const val PROGRESS_COLLECTION = "progressCollection"
	const val COACH_COLLECTION = "coachCollection"
	const val APPOINTMENT_COLLECTION = "appointmentCollection"
}

object ClientFields {
	const val NAME = "name"
	const val EMAIL = "email"
	const val PASSWORD = "password"
	const val PHONE = "phone"
	const val ADDRESS = "address"
}

object CoachFields {
	const val NAME = "name"
	const val EMAIL = "email"
	const val PASSWORD = "password"
	const val BIO = "bio"
	const val JOB_TITLE = "jobTitle"
	const val PHOTO = "photo"
}

object AppointmentFields {
	const val TITLE = "title"
	const val DURATION_MINUTES = "durationMinutes"
	const val DATE_TIME = "dateTime"
	const val NOTES = "notes"
	const val ATTENDED = "attended"
	const val REASON_FOR_NOT_ATTENDING = "reasonForNotAttending"
	const val APPOINTMENT_TYPE = "appointmentType"
	const val APPOINTMENT_STATUS = "appointmentStatus"
	const val APPOINTMENT_PRIORITY = "appointmentPriority"
}

object ProgressFields {

	const val MOTIVATION_AND_RESPONSIBILITY = "motivationAndResponsibility"
	const val MONEY_MANAGEMENT = "moneyManagement"
	const val RELATIONSHIPS = "relationships"
	const val SELF_CARE_AND_LIVING_SKILLS = "selfCareAndLivingSkills"
	const val DRUGS_AND_ALCOHOL = "drugsAndAlcohol"
	const val PHYSICAL_HEALTH = "physicalHealth"
	const val MENTAL_HEALTH = "mentalHealth"
	const val MEANINGFUL_USE_OF_TIME = "meaningfulUseOfTime"
	const val MANAGING_TENANACY_AND_ACCOMMODATION = "managingTenanacyAndAccommodation"
	const val CRIMINALOFFENDING = "criminalOffending"


}