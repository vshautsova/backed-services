package com.epam.vshautsova.configuration;

import com.epam.vshautsova.util.Constants;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

/**
 * Security Configuration which exposes default spring boot actuator.
 */
@Configuration
@EnableWebFluxSecurity
public class SecurityConfiguration
{
	@Bean
	public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http)
	{
		return http.authorizeExchange()
				.pathMatchers(Constants.ACTUATOR_PATH_MATHER).permitAll()
				.anyExchange().authenticated()
				.and()
				.build();
	}
}
