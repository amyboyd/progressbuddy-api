//package com.housingbuddy.housingbuddyapi.services
//
//import org.slf4j.Logger
//import org.slf4j.LoggerFactory
//import org.springframework.beans.factory.annotation.Autowired
//import org.springframework.security.core.authority.SimpleGrantedAuthority
//import org.springframework.security.core.userdetails.User
//import org.springframework.security.core.userdetails.UserDetailsService
//import org.springframework.security.core.userdetails.UsernameNotFoundException
//import org.springframework.stereotype.Component
//
//@Component
//class AuthenticationService (@Autowired private val clientService: ClientService) : UserDetailsService  {
//	override fun loadUserByUsername(email: String): User{
//		val client = clientService.retrieveClientIDByEmail(email) ?: throw UsernameNotFoundException("User not found")
//		val authorities = listOf(SimpleGrantedAuthority("client"), SimpleGrantedAuthority("coach"))
//		LOGGER.info("${client.email} logged in successfully")
//		return User(client.email, client.password, authorities)
//	}
//
//	private companion object {
//		val LOGGER: Logger = LoggerFactory.getLogger(AuthenticationService::class.java)
//	}
//}
//
