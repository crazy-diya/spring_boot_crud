package com.diya.checkmongo.mongo_and_spring;

import io.mongock.runner.springboot.EnableMongock;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableMongock
public class MongoAndSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(MongoAndSpringApplication.class, args);
	}

}

