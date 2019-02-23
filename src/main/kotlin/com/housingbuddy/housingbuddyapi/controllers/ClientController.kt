package com.housingbuddy.housingbuddyapi.controllers

import com.housingbuddy.housingbuddyapi.models.Client
import com.housingbuddy.housingbuddyapi.services.ClientService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("clients")
class ClientController (@Autowired private val clientService: ClientService) {

	@RequestMapping(value = ["register"], method = [RequestMethod.POST])
	fun register(
		@RequestParam(value = "name", defaultValue = "", required = true) name: String,
		@RequestParam(value = "email", defaultValue = "", required = true)  email: String,
		@RequestParam(value = "password", defaultValue = "", required = true)  password: String,
		@RequestParam(value = "phone", defaultValue = "", required = true)  phone: String,
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

	@RequestMapping(value = ["{id}"], method = [RequestMethod.GET])
	fun retrieveClient(@PathVariable clientID: String) = clientService.retrieveClientByID(clientID)

}