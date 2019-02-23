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

    @PostMapping("/{clientID}/check-in")
    @ApiOperation("check in")
    fun checkIn(
        @PathVariable clientID: String,
        @RequestParam latitude: Double,
        @RequestParam longitude: Double
    ) = clientService.checkIn(clientID, latitude, longitude)
}
