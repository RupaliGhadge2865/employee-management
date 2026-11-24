package com.train.mvc.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.train.mvc.model.Employee;

@Service
public class EmployeeService {

    private List<Employee> employees = new ArrayList<>();

    // Add sample employees
    public EmployeeService() {
        employees.add(new Employee(1, "Asha", "Engineering"));
        employees.add(new Employee(2, "Ravi", "QA"));
        employees.add(new Employee(3, "Meera", "HR"));
    }

    // Get all employees
    public List<Employee> getAllEmployees() {
        return employees;
    }

    // Register employee
    public void register(Employee employee) {

        // Validate ID
        if (employee.getId() == null || employee.getId() < 1) {
            throw new IllegalArgumentException(
                "ID is required and must be greater than 0");
        }

        // Validate name
        if (employee.getName() == null ||
            employee.getName().trim().isEmpty()) {
            throw new IllegalArgumentException("Name is required");
        }

        // Validate department
        if (employee.getDepartment() == null ||
            employee.getDepartment().trim().isEmpty()) {
            throw new IllegalArgumentException("Department is required");
        }

        // Check duplicate ID
        for (Employee e : employees) {
            if (e.getId() != null &&
                e.getId().equals(employee.getId())) {
                throw new IllegalArgumentException(
                    "Employee ID already exists");
            }
        }

        // Save employee
        employees.add(employee);
    }
}