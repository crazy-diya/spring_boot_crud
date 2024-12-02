package com.diya.checkmongo.mongo_and_spring.config;

import com.diya.checkmongo.mongo_and_spring.repository.EmployeeRepository;
import com.diya.checkmongo.mongo_and_spring.service.EmployeeService;
import io.mongock.api.annotations.ChangeUnit;
import io.mongock.api.annotations.Execution;
import io.mongock.api.annotations.RollbackBeforeExecution;
import io.mongock.api.annotations.RollbackExecution;
import org.springframework.data.mongodb.core.MongoTemplate;

@ChangeUnit(id="001",order = "1",author = "Sunimal")
public class DatabaseChangeLog {

    private final MongoTemplate mongoTemplate;
    private final EmployeeService employeeService;
    public DatabaseChangeLog(MongoTemplate mongoTemplate, EmployeeService employeeService) {
        this.mongoTemplate = mongoTemplate;
        this.employeeService = employeeService;
    }

    @Execution
    public void changeSet(){
        employeeService.getAllEmployees().stream().forEach(employee -> {mongoTemplate.save(employee, "employee");});
    }

    @RollbackExecution
    public void rollbackChangeSet(EmployeeRepository employeeRepository){
    }

    @RollbackBeforeExecution
    public void rollbackBeforeChangeSet(MongoTemplate mongoTemplate){}
}
