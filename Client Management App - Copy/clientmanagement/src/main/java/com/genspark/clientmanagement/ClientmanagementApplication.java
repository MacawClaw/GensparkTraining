package com.genspark.clientmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ClientmanagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientmanagementApplication.class, args);
	}

}
