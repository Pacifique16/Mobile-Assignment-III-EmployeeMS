package com.auca.employeemanagement;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class EmployeeRegistrationActivity extends AppCompatActivity {
    private EditText etEmployeeId, etNames, etEmail, etPhone, etDepartment;
    private RadioGroup rgGender;
    private Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_registration);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        etEmployeeId = findViewById(R.id.etEmployeeId);
        etNames = findViewById(R.id.etNames);
        etEmail = findViewById(R.id.etEmail);
        etPhone = findViewById(R.id.etPhone);
        etDepartment = findViewById(R.id.etDepartment);
        rgGender = findViewById(R.id.rgGender);
        btnSave = findViewById(R.id.btnSave);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String employeeId = etEmployeeId.getText().toString().trim();
                String names = etNames.getText().toString().trim();
                String email = etEmail.getText().toString().trim();
                String phone = etPhone.getText().toString().trim();
                String department = etDepartment.getText().toString().trim();

                int selectedGenderId = rgGender.getCheckedRadioButtonId();
                RadioButton rbGender = findViewById(selectedGenderId);
                String gender = rbGender != null ? rbGender.getText().toString() : "";

                if (employeeId.isEmpty() || names.isEmpty() || email.isEmpty() || 
                    phone.isEmpty() || department.isEmpty() || gender.isEmpty()) {
                    Toast.makeText(EmployeeRegistrationActivity.this, 
                        "Please fill all fields", Toast.LENGTH_SHORT).show();
                    return;
                }

                Employee employee = new Employee(employeeId, names, gender, email, phone, department);
                EmployeeManager.getInstance().addEmployee(employee);

                Toast.makeText(EmployeeRegistrationActivity.this, 
                    "Employee registered successfully", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
