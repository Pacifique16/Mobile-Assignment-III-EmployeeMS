package com.auca.employeemanagement;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

public class DepartmentActivity extends AppCompatActivity {
    private ListView listViewDepartments;
    private String[] departments = {"IT", "HR", "Finance", "Marketing", "Operations"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_department);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        listViewDepartments = findViewById(R.id.listViewDepartments);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, 
            android.R.layout.simple_list_item_1, departments);
        listViewDepartments.setAdapter(adapter);

        listViewDepartments.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String department = departments[position];
                Intent intent = new Intent(DepartmentActivity.this, EmployeeInDepartmentDetailActivity.class);
                intent.putExtra("department", department);
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
