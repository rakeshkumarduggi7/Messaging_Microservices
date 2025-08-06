package com.example.message_microservice_configserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class MessageMicroserviceConfigserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(MessageMicroserviceConfigserverApplication.class, args);
	}

}
