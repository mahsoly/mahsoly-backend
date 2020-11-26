package com.mahsoly.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import reactor.blockhound.BlockHound;

@ComponentScan("com.mahsoly.app")
@SpringBootApplication
public class MahsolyBackendApplication {

	public static void main(String[] args) {
		//ReactorDebugAgent.init();
		BlockHound.install(); // TODO: only enable in development
		SpringApplication.run(MahsolyBackendApplication.class, args);
	}

}
