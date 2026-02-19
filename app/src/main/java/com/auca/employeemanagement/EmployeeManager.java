package com.auca.employeemanagement;

import android.content.Context;
import java.util.List;

public class EmployeeManager {
    private static EmployeeManager instance;
    private MyDbHelper dbHelper;

    private EmployeeManager(Context context) {
        dbHelper = new MyDbHelper(context.getApplicationContext());
    }

    public static synchronized EmployeeManager getInstance(Context context) {
        if (instance == null) {
            instance = new EmployeeManager(context.getApplicationContext());
        }
        return instance;
    }

    public void addEmployee(Employee employee) {
        dbHelper.addEmployee(employee);
    }

    public List<Employee> getAllEmployees() {
        return dbHelper.getAllEmployees();
    }

    public List<Employee> getEmployeesByDepartment(String department) {
        return dbHelper.getEmployeesByDepartment(department);
    }

    public void deleteEmployee(String employeeId) {
        dbHelper.deleteEmployee(employeeId);
    }

    public void updateEmployee(Employee employee) {
        dbHelper.updateEmployee(employee);
    }

    public void deleteAllEmployees() {
        dbHelper.deleteAllEmployees();
    }
}
