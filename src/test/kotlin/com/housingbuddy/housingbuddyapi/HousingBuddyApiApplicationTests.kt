package com.housingbuddy.housingbuddyapi

import com.housingbuddy.housingbuddyapi.services.ClientService
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest
class HousingBuddyApiApplicationTests {
    @Autowired
    lateinit var clientService: ClientService

    @Test
    fun contextLoads() {
    }

    fun housingServiceGeneralTests() {
    }
}
