package com.housingbuddy.housingbuddyapi.controllers

import com.housingbuddy.housingbuddyapi.models.Client
import com.housingbuddy.housingbuddyapi.services.ClientService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiParam

@Api
@RestController
@RequestMapping("clients")
class ClientController (@Autowired private val clientService: ClientService) {

	@PostMapping(value = ["register"])
	@ApiOperation(value = "registration")
	fun register(
		@ApiParam(value = "name")
		@RequestParam(value = "name", defaultValue = "", required = true) name: String,
		@ApiParam(value = "email")
		@RequestParam(value = "email", defaultValue = "", required = true)  email: String,
		@ApiParam(value = "password")
		@RequestParam(value = "password", defaultValue = "", required = true)  password: String,
		@ApiParam(value = "phone")
		@RequestParam(value = "phone", defaultValue = "", required = true)  phone: String,
		@ApiParam(value = "address")
		@RequestParam(value = "address", defaultValue = "", required = true)  address: String
	) {
		val client = Client (
			name = name,
			email = email,
			password = password,
			phone = phone,
			address = address
		)
		clientService.registerClient(client)
	}

	@GetMapping(value = ["{id}"])
	@ApiOperation(value = "get client")
	fun retrieveClient(
		@ApiParam(value = "clientID")
		@PathVariable clientID: String
	) = clientService.retrieveClientByID(clientID)

}