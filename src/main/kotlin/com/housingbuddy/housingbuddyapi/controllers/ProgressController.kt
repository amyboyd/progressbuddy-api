package com.housingbuddy.housingbuddyapi.controllers

import com.housingbuddy.housingbuddyapi.services.ProgressService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RestController

@RestController
class ProgressController (@Autowired private val progressService: ProgressService) {



}