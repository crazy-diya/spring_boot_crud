package com.diya.checkmongo.mongo_and_spring;

import org.springframework.boot.SpringApplication;

public class TestMongoAndSpringApplication {

	public static void main(String[] args) {
		SpringApplication.from(MongoAndSpringApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
