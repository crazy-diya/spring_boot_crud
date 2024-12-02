package com.diya.checkmongo.mongo_and_spring.service;

import com.diya.checkmongo.mongo_and_spring.model.Employee;
import com.diya.checkmongo.mongo_and_spring.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public void addEmployee(Employee employee) {
        employeeRepository.insert(employee);
    }

    public void updateEmployee(Employee employee) {
        Employee exictEmployee = employeeRepository.findById(
                employee.getId()).orElseThrow(
                () -> new RuntimeException(
                        String.format(
                                "Employee not found By ID %s", employee.getId()
                        )
                )
        );
        exictEmployee.setName(employee.getName());
        exictEmployee.setSalary(employee.getSalary());
        exictEmployee.setAge(employee.getAge());
        exictEmployee.setWorkType(employee.getWorkType());

        employeeRepository.save(exictEmployee);
    }

    public void deleteEmployee(String id) {
        employeeRepository.deleteById(id);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeByName(String employeeName) {
        return employeeRepository.findByName(employeeName).orElseThrow(() -> new RuntimeException(String.format("Cannot find employee by name $s", employeeName)));
    }
}
