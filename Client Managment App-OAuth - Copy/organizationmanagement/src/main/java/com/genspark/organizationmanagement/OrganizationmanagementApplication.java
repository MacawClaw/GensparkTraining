package com.genspark.organizationmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class OrganizationmanagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrganizationmanagementApplication.class, args);
	}

}
