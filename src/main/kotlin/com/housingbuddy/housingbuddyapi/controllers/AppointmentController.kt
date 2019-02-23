package com.housingbuddy.housingbuddyapi.controllers

import com.housingbuddy.housingbuddyapi.models.AppointmentStatus
import com.housingbuddy.housingbuddyapi.services.AppointmentService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@Api
@RestController
@RequestMapping("appointments")
class AppointmentController(@Autowired private val appointmentService: AppointmentService) {

    @GetMapping(value = ["getAppointmentsForClient/{clientID}"])
    @ApiOperation(value = "get appointments by client ID")
    fun retrieveAppointmentsForClient(
        @PathVariable clientID: String
    ) = appointmentService.retrieveAppointmentByClientID(clientID)

    @GetMapping(value = ["getAppointment/{appointmentID}"])
    @ApiOperation(value = "get appointments by appointment ID")
    fun retrieveAppointmentByID(
        @PathVariable appointmentID: String
    ) = appointmentService.retrieveAppointmentByID(appointmentID)

    @PostMapping(value = ["confirmAttendance/{appointmentID}"])
    @ApiOperation(value = "confirm attendance  for appointment ")
    fun confirmAppointmentAttendance(
        @PathVariable appointmentID: String,
        @RequestParam(required = true, name = "appointmentStatus") appointmenStatus: AppointmentStatus,
        @RequestParam(required = false, name = "reasonForNotAttending") reasonForNotAttending: String?
    ) = appointmentService.updateAttendanceStatus(appointmentID = appointmentID, status = appointmenStatus, notAttendingReason = reasonForNotAttending)


}
