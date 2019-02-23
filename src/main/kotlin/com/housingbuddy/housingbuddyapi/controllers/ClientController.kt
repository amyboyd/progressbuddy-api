package com.housingbuddy.housingbuddyapi.controllers

import com.housingbuddy.housingbuddyapi.services.ClientService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiParam
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import javax.websocket.server.PathParam

@Api
@RestController
@RequestMapping("clients" , produces = ["application/json"])
class ClientController(@Autowired private val clientService: ClientService) {
    @GetMapping(value = ["{clientID}"])
    @ApiOperation(value = "get client")
    fun retrieveClient(
        @PathVariable clientID: String
    ) = clientService.retrieveClientByID(clientID)

    @PostMapping(value = ["{clientID}"])
    @ApiOperation(value = "check in")
    fun checkIn(
        @PathVariable clientID: String,
        @RequestParam latitude: Double,
        @RequestParam longitude: Double
    ) = clientService.checkIn(clientID, latitude, longitude)
}
