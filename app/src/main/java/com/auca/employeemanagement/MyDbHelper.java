package com.auca.employeemanagement;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class MyDbHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "employee.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_EMPLOYEES = "employees";
    private static final String COLUMN_ID = "employee_id";
    private static final String COLUMN_NAME = "names";
    private static final String COLUMN_GENDER = "gender";
    private static final String COLUMN_EMAIL = "email";
    private static final String COLUMN_PHONE = "phone";
    private static final String COLUMN_DEPARTMENT = "department";

    public MyDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE " + TABLE_EMPLOYEES + "("
                + COLUMN_ID + " TEXT PRIMARY KEY,"
                + COLUMN_NAME + " TEXT,"
                + COLUMN_GENDER + " TEXT,"
                + COLUMN_EMAIL + " TEXT,"
                + COLUMN_PHONE + " TEXT,"
                + COLUMN_DEPARTMENT + " TEXT"
                + ")";
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_EMPLOYEES);
        onCreate(db);
    }

    public long addEmployee(Employee employee) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, employee.getEmployeeId());
        values.put(COLUMN_NAME, employee.getNames());
        values.put(COLUMN_GENDER, employee.getGender());
        values.put(COLUMN_EMAIL, employee.getEmail());
        values.put(COLUMN_PHONE, employee.getPhone());
        values.put(COLUMN_DEPARTMENT, employee.getDepartment());
        long result = db.insert(TABLE_EMPLOYEES, null, values);
        db.close();
        return result;
    }

    public List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_EMPLOYEES, null);
        if (cursor.moveToFirst()) {
            do {
                employees.add(new Employee(
                    cursor.getString(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4),
                    cursor.getString(5)
                ));
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return employees;
    }

    public List<Employee> getEmployeesByDepartment(String department) {
        List<Employee> employees = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_EMPLOYEES, null, COLUMN_DEPARTMENT + "=?", 
                new String[]{department}, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                employees.add(new Employee(
                    cursor.getString(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4),
                    cursor.getString(5)
                ));
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return employees;
    }

    public int deleteEmployee(String employeeId) {
        SQLiteDatabase db = this.getWritableDatabase();
        int result = db.delete(TABLE_EMPLOYEES, COLUMN_ID + "=?", new String[]{employeeId});
        db.close();
        return result;
    }

    public void deleteAllEmployees() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_EMPLOYEES, null, null);
        db.close();
    }
}
