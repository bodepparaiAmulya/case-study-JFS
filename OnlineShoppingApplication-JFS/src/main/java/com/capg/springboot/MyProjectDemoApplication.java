package com.capg.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyProjectDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyProjectDemoApplication.class, args);
		System.out.println("Server Started");
	}

}