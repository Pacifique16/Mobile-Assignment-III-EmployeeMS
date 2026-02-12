package com.auca.employeemanagement;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class EmployeeDetailActivity extends AppCompatActivity {
    private TextView tvEmployeeId, tvNames, tvGender, tvEmail, tvPhone, tvDepartment;

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

        Employee employee = (Employee) getIntent().getSerializableExtra("employee");

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
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
