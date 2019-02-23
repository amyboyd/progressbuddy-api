package com.housingbuddy.housingbuddyapi.controllers

import com.housingbuddy.housingbuddyapi.services.AppointmentService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@Api
@RestController
@RequestMapping("appointments")
class AppointmentController(@Autowired private val appointmentService: AppointmentService) {

    @GetMapping(value = ["getAppointmentsForClient/{clientID}"])
    @ApiOperation(value = "get appointments by client ID")
    fun retrieveAppointmentsForClient(
        @PathVariable clientID: String
    ) = appointmentService.retrieveAppointment(clientID)

    @GetMapping(value = ["getAppointment/{appointmentID}"])
    @ApiOperation(value = "get appointments by Appointment ID")
    fun retrieveAppointmentByID(
        @PathVariable appointmentID: String
    ) = appointmentService.retrieveAppointmentByID(appointmentID)

}
