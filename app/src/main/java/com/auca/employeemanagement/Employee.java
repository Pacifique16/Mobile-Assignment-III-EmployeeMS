package com.auca.employeemanagement;

import java.io.Serializable;

public class Employee implements Serializable {
    private String employeeId;
    private String names;
    private String gender;
    private String email;
    private String phone;
    private String department;

    public Employee(String employeeId, String names, String gender, String email, String phone, String department) {
        this.employeeId = employeeId;
        this.names = names;
        this.gender = gender;
        this.email = email;
        this.phone = phone;
        this.department = department;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public String getNames() {
        return names;
    }

    public String getGender() {
        return gender;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return employeeId + " - " + names;
    }
}
