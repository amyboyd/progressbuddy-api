package com.housingbuddy.housingbuddyapi.configs

import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter

@Configuration
@EnableConfigurationProperties
@EnableWebSecurity
class SecurityConfiguration() : WebSecurityConfigurerAdapter() {
    override fun configure(http: HttpSecurity) {
        http.httpBasic()
            .disable()
            .headers()
            .httpStrictTransportSecurity()
            .and().frameOptions().sameOrigin()
            .and().csrf().disable()
            .antMatcher("/")
            .addFilterBefore(AuthorizationHeaderFilter(), BasicAuthenticationFilter::class.java)
    }
}
