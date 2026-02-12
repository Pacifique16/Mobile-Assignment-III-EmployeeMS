package com.auca.employeemanagement;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.List;

public class EmployeeInDepartmentDetailActivity extends AppCompatActivity {
    private TextView tvDepartmentName;
    private ListView listViewEmployees;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_in_department);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        tvDepartmentName = findViewById(R.id.tvDepartmentName);
        listViewEmployees = findViewById(R.id.listViewDepartmentEmployees);

        String department = getIntent().getStringExtra("department");
        tvDepartmentName.setText("Department: " + department);

        List<Employee> employees = EmployeeManager.getInstance(this).getEmployeesByDepartment(department);

        ArrayAdapter<Employee> adapter = new ArrayAdapter<>(this, 
            android.R.layout.simple_list_item_1, employees);
        listViewEmployees.setAdapter(adapter);

        listViewEmployees.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Employee employee = employees.get(position);
                Intent intent = new Intent(EmployeeInDepartmentDetailActivity.this, EmployeeDetailActivity.class);
                intent.putExtra("employee", employee);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
