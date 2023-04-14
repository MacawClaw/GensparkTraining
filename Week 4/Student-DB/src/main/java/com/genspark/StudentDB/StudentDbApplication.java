package com.genspark.StudentDB;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentDbApplication.class, args);
	}

}

/*
Test data:

"fullName": "Clark Kent",
"address": "Smallville, KS",
"phone": "112-555-5555"

"fullName": "Barry Allen",
"address": "Central City, MO",
"phone": "113-555-5555"

"fullName": "Bruce Wayne",
"address": "Gotham City, NJ",
"phone": "114-555-5555"

 */