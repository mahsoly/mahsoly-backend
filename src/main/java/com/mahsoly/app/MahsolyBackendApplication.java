package com.mahsoly.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import reactor.blockhound.BlockHound;

@ComponentScan("com.mahsoly.app")
@SpringBootApplication
public class MahsolyBackendApplication {

	public static void main(String[] args) {
		// ReactorDebugAgent.init();
		BlockHound.builder().allowBlockingCallsInside("ReactiveRemoteJWKSource", "getJWKSet").install(); // Allow blocking retrieval of JWK on start of the application
		SpringApplication.run(MahsolyBackendApplication.class, args);
	}

}
