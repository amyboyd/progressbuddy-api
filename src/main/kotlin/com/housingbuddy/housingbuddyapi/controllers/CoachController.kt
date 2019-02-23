package com.housingbuddy.housingbuddyapi.controllers

import com.housingbuddy.housingbuddyapi.services.CoachService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RestController

@RestController
class CoachController (@Autowired private val coachService: CoachService) {


}