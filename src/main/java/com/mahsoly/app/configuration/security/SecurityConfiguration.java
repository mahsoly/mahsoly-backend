package com.mahsoly.app.configuration.security;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableReactiveMethodSecurity;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.ReactiveJwtDecoders;
import org.springframework.security.oauth2.server.resource.authentication.ReactiveJwtAuthenticationConverter;
import org.springframework.security.web.server.SecurityWebFilterChain;

import com.mahsoly.app.common.utils.Utils;

@Configuration
@EnableWebFluxSecurity
@EnableReactiveMethodSecurity
public class SecurityConfiguration {

	@Value("${mahsoly.security.issuer-uri}")
	private String issuerUri;
	

	@Bean
	public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
		http.csrf().disable().authorizeExchange().anyExchange().permitAll().and().oauth2ResourceServer()
				.jwt((config) -> config.jwtDecoder(ReactiveJwtDecoders.fromOidcIssuerLocation(issuerUri))
						.jwtAuthenticationConverter(getJwtAuthenticationConverter()));
		return http.build();
	}

	ReactiveJwtAuthenticationConverter getJwtAuthenticationConverter() {
		ReactiveJwtAuthenticationConverter converter = new ReactiveJwtAuthenticationConverter();
		converter.setJwtGrantedAuthoritiesConverter(jwt -> {
			return Utils.getFluxBlockingCall(() -> {
				return jwt.getClaimAsStringList("authorities").stream()
						.map(authority -> new SimpleGrantedAuthority(authority)).collect(Collectors.toList());
			});
		});
		return converter;
	}

}