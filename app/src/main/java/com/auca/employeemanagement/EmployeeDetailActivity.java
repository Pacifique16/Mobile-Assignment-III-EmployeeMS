package com.auca.employeemanagement;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class EmployeeDetailActivity extends AppCompatActivity {
    private TextView tvEmployeeId, tvNames, tvGender, tvEmail, tvPhone, tvDepartment;
    private Button btnEdit, btnDelete;
    private Employee employee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_detail);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        tvEmployeeId = findViewById(R.id.tvEmployeeId);
        tvNames = findViewById(R.id.tvNames);
        tvGender = findViewById(R.id.tvGender);
        tvEmail = findViewById(R.id.tvEmail);
        tvPhone = findViewById(R.id.tvPhone);
        tvDepartment = findViewById(R.id.tvDepartment);
        btnEdit = findViewById(R.id.btnEdit);
        btnDelete = findViewById(R.id.btnDelete);

        employee = (Employee) getIntent().getSerializableExtra("employee");

        if (employee != null) {
            tvEmployeeId.setText("ID: " + employee.getEmployeeId());
            tvNames.setText("Name: " + employee.getNames());
            tvGender.setText("Gender: " + employee.getGender());
            tvEmail.setText(employee.getEmail());
            tvPhone.setText(employee.getPhone());
            tvDepartment.setText("Department: " + employee.getDepartment());

            tvPhone.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent dialIntent = new Intent(Intent.ACTION_DIAL);
                    dialIntent.setData(Uri.parse("tel:" + employee.getPhone()));
                    startActivity(dialIntent);
                }
            });

            tvEmail.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
                    emailIntent.setData(Uri.parse("mailto:" + employee.getEmail()));
                    emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Employee Inquiry");
                    startActivity(Intent.createChooser(emailIntent, "Send Email"));
                }
            });

            btnEdit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showEditDialog();
                }
            });

            btnDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showDeleteDialog();
                }
            });
        }
    }

    private void showEditDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        
        final EditText etId = new EditText(this);
        final EditText etName = new EditText(this);
        final EditText etGender = new EditText(this);
        final EditText etEmail = new EditText(this);
        final EditText etPhone = new EditText(this);
        final EditText etDept = new EditText(this);
        
        etId.setText(employee.getEmployeeId());
        etId.setHint("Employee ID");
        etId.setEnabled(false);
        etName.setText(employee.getNames());
        etName.setHint("Name");
        etGender.setText(employee.getGender());
        etGender.setHint("Gender (Male/Female)");
        etEmail.setText(employee.getEmail());
        etEmail.setHint("Email");
        etPhone.setText(employee.getPhone());
        etPhone.setHint("Phone");
        etDept.setText(employee.getDepartment());
        etDept.setHint("Department");
        
        android.widget.LinearLayout layout = new android.widget.LinearLayout(this);
        layout.setOrientation(android.widget.LinearLayout.VERTICAL);
        layout.setPadding(50, 40, 50, 10);
        layout.addView(etId);
        layout.addView(etName);
        layout.addView(etGender);
        layout.addView(etEmail);
        layout.addView(etPhone);
        layout.addView(etDept);
        
        builder.setView(layout)
            .setTitle("Edit Employee")
            .setPositiveButton("Save", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    employee.setNames(etName.getText().toString());
                    employee.setGender(etGender.getText().toString());
                    employee.setEmail(etEmail.getText().toString());
                    employee.setPhone(etPhone.getText().toString());
                    employee.setDepartment(etDept.getText().toString());
                    
                    EmployeeManager.getInstance(EmployeeDetailActivity.this).updateEmployee(employee);
                    updateUI();
                    Toast.makeText(EmployeeDetailActivity.this, "Employee updated", Toast.LENGTH_SHORT).show();
                }
            })
            .setNegativeButton("Cancel", null)
            .show();
    }

    private void showDeleteDialog() {
        new AlertDialog.Builder(this)
            .setTitle("Delete Employee")
            .setMessage("Are you sure you want to delete " + employee.getNames() + "?")
            .setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    EmployeeManager.getInstance(EmployeeDetailActivity.this).deleteEmployee(employee.getEmployeeId());
                    Toast.makeText(EmployeeDetailActivity.this, "Employee deleted", Toast.LENGTH_SHORT).show();
                    finish();
                }
            })
            .setNegativeButton("Cancel", null)
            .show();
    }

    private void updateUI() {
        tvEmployeeId.setText("ID: " + employee.getEmployeeId());
        tvNames.setText("Name: " + employee.getNames());
        tvGender.setText("Gender: " + employee.getGender());
        tvEmail.setText(employee.getEmail());
        tvPhone.setText(employee.getPhone());
        tvDepartment.setText("Department: " + employee.getDepartment());
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
