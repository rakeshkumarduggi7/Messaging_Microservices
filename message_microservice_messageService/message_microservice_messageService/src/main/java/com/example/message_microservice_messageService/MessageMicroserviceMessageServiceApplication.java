package com.example.message_microservice_messageService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MessageMicroserviceMessageServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MessageMicroserviceMessageServiceApplication.class, args);
	}

}
