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

    public void setNames(String names) {
        this.names = names;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return employeeId + " - " + names;
    }
}
