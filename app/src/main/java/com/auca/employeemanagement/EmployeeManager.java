package com.auca.employeemanagement;

import java.util.ArrayList;
import java.util.List;

public class EmployeeManager {
    private static EmployeeManager instance;
    private List<Employee> employees;

    private EmployeeManager() {
        employees = new ArrayList<>();
        // Add sample employees
        employees.add(new Employee("EMP001", "John Doe", "Male", "john.doe@auca.ac.rw", "+250788123456", "IT"));
        employees.add(new Employee("EMP002", "Jane Smith", "Female", "jane.smith@auca.ac.rw", "+250788234567", "HR"));
        employees.add(new Employee("EMP003", "Bob Johnson", "Male", "bob.johnson@auca.ac.rw", "+250788345678", "Finance"));
    }

    public static synchronized EmployeeManager getInstance() {
        if (instance == null) {
            instance = new EmployeeManager();
        }
        return instance;
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public List<Employee> getAllEmployees() {
        return employees;
    }

    public List<Employee> getEmployeesByDepartment(String department) {
        List<Employee> result = new ArrayList<>();
        for (Employee emp : employees) {
            if (emp.getDepartment().equalsIgnoreCase(department)) {
                result.add(emp);
            }
        }
        return result;
    }
}
