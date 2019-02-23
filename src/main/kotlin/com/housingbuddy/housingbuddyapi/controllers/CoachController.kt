package com.housingbuddy.housingbuddyapi.controllers

import com.housingbuddy.housingbuddyapi.services.CoachService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@Api
@RestController
@RequestMapping("/coaches", produces = ["application/json"])
class CoachController(@Autowired private val coachService: CoachService) {

    @GetMapping("/{coachID}")
    @ApiOperation("get coach")
    fun retrieveCoach(
        @PathVariable coachID: String
    ) = coachService.retrieveCoachByID(coachID)

    @GetMapping("/{coachID}/clients")
    @ApiOperation("get coach events")
    fun retrieveCoachEvents(
        @PathVariable coachID: String
    ) = coachService.retrieveCoachByID(coachID)?.clients

}
