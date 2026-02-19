package com.auca.employeemanagement;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.auca.employeemanagement.utils.CSVUtils;
import com.auca.employeemanagement.utils.NetworkUtils;

import java.io.File;
import java.util.List;

public class EmployeeListActivity extends AppCompatActivity {
    private ListView listViewEmployees;
    private Button btnRegister, btnDepartments, btnStopMusic, btnClearData, btnExportCSV;
    private android.widget.TextView tvNetworkStatus;
    private ArrayAdapter<Employee> adapter;
    private BroadcastReceiver networkReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_list);

        listViewEmployees = findViewById(R.id.listViewEmployees);
        btnRegister = findViewById(R.id.btnRegister);
        btnDepartments = findViewById(R.id.btnDepartments);
        btnStopMusic = findViewById(R.id.btnStopMusic);
        btnClearData = findViewById(R.id.btnClearData);
        btnExportCSV = findViewById(R.id.btnExportCSV);
        tvNetworkStatus = findViewById(R.id.tvNetworkStatus);

        updateNetworkStatus();
        setupNetworkReceiver();

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

        btnClearData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EmployeeManager.getInstance(EmployeeListActivity.this).deleteAllEmployees();
                loadEmployees();
                Toast.makeText(EmployeeListActivity.this, "All data cleared", Toast.LENGTH_SHORT).show();
            }
        });

        btnExportCSV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    List<Employee> employees = EmployeeManager.getInstance(EmployeeListActivity.this).getAllEmployees();
                    String filePath = CSVUtils.exportEmployees(EmployeeListActivity.this, employees);
                    Toast.makeText(EmployeeListActivity.this, "Exported to Documents folder: " + new File(filePath).getName(), Toast.LENGTH_LONG).show();
                    CSVUtils.openCSVFile(EmployeeListActivity.this, filePath);
                } catch (Exception e) {
                    Toast.makeText(EmployeeListActivity.this, "Export failed: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Start background music service
        startService(new Intent(this, MusicPlayerService.class));
    }

    private void setupNetworkReceiver() {
        networkReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                updateNetworkStatus();
            }
        };
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadEmployees();
        updateNetworkStatus();
        registerReceiver(networkReceiver, new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION));
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(networkReceiver);
    }

    private void updateNetworkStatus() {
        String connectionType = NetworkUtils.getConnectionType(this);
        tvNetworkStatus.setText("Network: " + connectionType);
        
        if (connectionType.equals("No Connection")) {
            tvNetworkStatus.setTextColor(0xFFF44336);
        } else {
            tvNetworkStatus.setTextColor(0xFF4CAF50);
        }
    }

    private void loadEmployees() {
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, 
                EmployeeManager.getInstance(this).getAllEmployees());
        listViewEmployees.setAdapter(adapter);
    }
}
