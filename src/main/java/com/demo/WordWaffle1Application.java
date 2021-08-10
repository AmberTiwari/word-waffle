package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com")
public class WordWaffle1Application {

	public static void main(String[] args) {
		SpringApplication.run(WordWaffle1Application.class, args);
	}

}
