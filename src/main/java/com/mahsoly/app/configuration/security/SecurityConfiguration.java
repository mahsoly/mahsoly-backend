package com.mahsoly.app.configuration.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.ReactiveAuthenticationManager;
import org.springframework.security.authentication.UserDetailsRepositoryReactiveAuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableReactiveMethodSecurity;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

import com.mahsoly.app.user.service.UserService;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebFluxSecurity
@RequiredArgsConstructor
@EnableReactiveMethodSecurity
public class SecurityConfiguration {

	final UserService userService;

	@Bean
	public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
		http.csrf().disable().authorizeExchange().anyExchange().permitAll().and()
				.oauth2ResourceServer().jwt();
		return http.build();
	}

	@Bean
	ReactiveAuthenticationManager authenticationManager(UserService userService) {
		return new UserDetailsRepositoryReactiveAuthenticationManager(userService);
	}

}