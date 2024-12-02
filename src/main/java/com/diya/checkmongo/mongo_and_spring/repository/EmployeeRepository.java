package com.diya.checkmongo.mongo_and_spring.repository;

import com.diya.checkmongo.mongo_and_spring.model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface EmployeeRepository extends MongoRepository<Employee, String> {
    @Query("{'name': ?0}")
    Optional<Employee> findByName(String name);
}
