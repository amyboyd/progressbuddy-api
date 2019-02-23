package com.housingbuddy.housingbuddyapi.controllers

import com.housingbuddy.housingbuddyapi.services.ClientService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@Api
@RestController
@RequestMapping("/clients", produces = ["application/json"])
class ClientController(@Autowired private val clientService: ClientService) {
    @GetMapping("/{clientID}")
    @ApiOperation("get client")
    fun retrieveClient(
        @PathVariable clientID: String
    ) = clientService.retrieveClientByID(clientID)

    @GetMapping("/{clientID}/events")
    @ApiOperation("get client events")
    fun retrieveClientEvents(
        @PathVariable clientID: String
    ) = clientService.retrieveClientByID(clientID)?.events

    @GetMapping("/{clientID}/progress")
    @ApiOperation("get client progress")
    fun retrieveClientProgress(
        @PathVariable clientID: String
    ) = clientService.retrieveClientByID(clientID)?.progress

    @GetMapping("/{clientID}/appointments")
    @ApiOperation("get client appointments")
    fun retrieveClientAppointments(
        @PathVariable clientID: String
    ) = clientService.retrieveClientByID(clientID)?.appointments

    @GetMapping("/{clientID}/checkInStatus")
    @ApiOperation("get client check-in status")
    fun retrieveClientCheckInStatus(
        @PathVariable clientID: String
    ): LinkedHashMap<String, String> {
        val lastCheckInTime =  clientService.retrieveClientByID(clientID)?.lastCheckedInAt
        val lastLongitude = clientService.retrieveClientByID(clientID)?.lastCheckedInLongitude
        val lastCheckInDescription = clientService.retrieveClientByID(clientID)?.lastCheckedInDescription

        return linkedMapOf (
            "lastCheckInTime" to lastCheckInTime.toString(),
            "lastLongitude" to lastLongitude.toString(),
            "lastCheckInDescription" to lastCheckInDescription.toString()
        )
    }

    @PostMapping("/{clientID}/check-in")
    @ApiOperation("check in")
    fun checkIn(
        @PathVariable clientID: String,
        @RequestParam latitude: Double,
        @RequestParam longitude: Double
    ) = clientService.checkIn(clientID, latitude, longitude)
}
