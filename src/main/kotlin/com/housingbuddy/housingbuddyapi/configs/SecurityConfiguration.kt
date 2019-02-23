//package com.housingbuddy.housingbuddyapi.configs
//
//import com.housingbuddy.housingbuddyapi.services.AuthenticationService
//import org.springframework.beans.factory.annotation.Autowired
//import org.springframework.boot.context.properties.EnableConfigurationProperties
//import org.springframework.context.annotation.Bean
//import org.springframework.context.annotation.Configuration
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
//import org.springframework.security.config.annotation.web.builders.HttpSecurity
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
//import org.springframework.security.crypto.password.PasswordEncoder
//
//@Configuration
//@EnableConfigurationProperties
//@EnableWebSecurity
//class SecurityConfiguration (@Autowired private val userDetailsService: AuthenticationService) : WebSecurityConfigurerAdapter() {
//
//	override fun configure(http: HttpSecurity) {
//		http
//			.authorizeRequests()
//			.antMatchers("/", "/clients").permitAll()
//			.anyRequest().authenticated()
//			.and()
//			.formLogin()
//			.loginProcessingUrl("/performLogin")
//			.permitAll()
//			.and()
//			.logout()
//			.permitAll()
//	}
//
//	@Bean
//	fun passwordEncoder(): PasswordEncoder {
//		return BCryptPasswordEncoder()
//	}
//
//	override fun configure(builder: AuthenticationManagerBuilder) {
//		builder.userDetailsService(userDetailsService)
//	}
//}
