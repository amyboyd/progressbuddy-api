package com.housingbuddy.housingbuddyapi.controllers

import com.housingbuddy.housingbuddyapi.services.ClientService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiParam
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@Api
@RestController
@RequestMapping("clients")
class ClientController(@Autowired private val clientService: ClientService) {
    @GetMapping(value = ["{id}"])
    @ApiOperation(value = "get client")
    fun retrieveClient(
        @ApiParam(value = "clientID")
        @PathVariable clientID: String
    ) = clientService.retrieveClientByID(clientID)
}
