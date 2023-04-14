package com.genspark.BookDB;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookDbApplication.class, args);
	}

}


/*
Test data:

"title": "1984",
"author": "George Orwell",
"genre": "Science Fiction",
"description": "1984 is a dystopian social science fiction novel and cautionary tale."

"title": "Sula",
"author": "Toni Morrison",
"genre": "African-American literature",
"description": "This rich and moving novel traces the lives of two black heroines from their
close-knit childhood in a small Ohio town, through their sharply divergent paths of womanhood,
to their ultimate confrontation and reconciliation."
 */