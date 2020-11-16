package com.mahsoly.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import reactor.blockhound.BlockHound;
import reactor.tools.agent.ReactorDebugAgent;

@SpringBootApplication
public class MahsolyBackendApplication {

	public static void main(String[] args) {
		ReactorDebugAgent.init();
		BlockHound.install();
		SpringApplication.run(MahsolyBackendApplication.class, args);
	}

}
