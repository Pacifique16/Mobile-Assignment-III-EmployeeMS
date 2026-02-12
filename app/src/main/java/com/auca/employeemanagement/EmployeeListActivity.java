package com.auca.employeemanagement;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

public class EmployeeListActivity extends AppCompatActivity {
    private ListView listViewEmployees;
    private Button btnRegister, btnDepartments, btnStopMusic;
    private ArrayAdapter<Employee> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_list);

        listViewEmployees = findViewById(R.id.listViewEmployees);
        btnRegister = findViewById(R.id.btnRegister);
        btnDepartments = findViewById(R.id.btnDepartments);
        btnStopMusic = findViewById(R.id.btnStopMusic);

        loadEmployees();

        listViewEmployees.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Employee employee = adapter.getItem(position);
                Intent intent = new Intent(EmployeeListActivity.this, EmployeeDetailActivity.class);
                intent.putExtra("employee", employee);
                startActivity(intent);
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(EmployeeListActivity.this, EmployeeRegistrationActivity.class));
            }
        });

        btnDepartments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(EmployeeListActivity.this, DepartmentActivity.class));
            }
        });

        btnStopMusic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopService(new Intent(EmployeeListActivity.this, MusicPlayerService.class));
            }
        });

        // Start background music service
        startService(new Intent(this, MusicPlayerService.class));
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadEmployees();
    }

    private void loadEmployees() {
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, 
                EmployeeManager.getInstance().getAllEmployees());
        listViewEmployees.setAdapter(adapter);
    }
}
