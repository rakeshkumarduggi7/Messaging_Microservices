package com.example.message_microservice_userservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class MessageMicroserviceUserserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MessageMicroserviceUserserviceApplication.class, args);
	}

}
