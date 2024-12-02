package com.diya.checkmongo.mongo_and_spring.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document("employee")   // define this as a MongoDB document
public class Employee {
    @Id
    private String id;
    @Field(name = "name")
    @Indexed(unique = true)
    private String name;
    @Field(name = "age")
    private int age;
    @Field(name = "workType")
    private WorkType workType;
    @Field(name = "salary")
    private int salary;

    public Employee(String id, String name, int age, WorkType workType, int salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.workType = workType;
        this.salary = salary;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public WorkType getWorkType() {
        return workType;
    }

    public void setWorkType(WorkType workType) {
        this.workType = workType;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
