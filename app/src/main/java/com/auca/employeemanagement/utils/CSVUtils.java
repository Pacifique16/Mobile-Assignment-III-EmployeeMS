package com.auca.employeemanagement.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;

import androidx.core.content.FileProvider;

import com.auca.employeemanagement.Employee;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class CSVUtils {
    private static final String DATE_FORMAT = "yyyyMMdd_HHmmss";
    private static final String CSV_SEPARATOR = ",";
    private static final String CSV_QUOTE = "\"";

    private static String getCurrentTimestamp() {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT, Locale.getDefault());
        return sdf.format(new Date());
    }

    private static String escapeCSV(String value) {
        if (value == null) {
            return "";
        }
        return value.replace("\"", "\"\"");
    }

    public static String exportEmployees(Context context, List<Employee> employees) throws IOException {
        String fileName = "employees_" + getCurrentTimestamp() + ".csv";
        File documentsDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS);
        if (!documentsDir.exists()) {
            documentsDir.mkdirs();
        }
        File file = new File(documentsDir, fileName);

        try (FileWriter writer = new FileWriter(file)) {
            writer.append("Employee ID,Name,Gender,Email,Phone,Department\n");

            for (Employee employee : employees) {
                writer.append(CSV_QUOTE).append(escapeCSV(employee.getEmployeeId())).append(CSV_QUOTE);
                writer.append(CSV_SEPARATOR);
                writer.append(CSV_QUOTE).append(escapeCSV(employee.getNames())).append(CSV_QUOTE);
                writer.append(CSV_SEPARATOR);
                writer.append(CSV_QUOTE).append(escapeCSV(employee.getGender())).append(CSV_QUOTE);
                writer.append(CSV_SEPARATOR);
                writer.append(CSV_QUOTE).append(escapeCSV(employee.getEmail())).append(CSV_QUOTE);
                writer.append(CSV_SEPARATOR);
                writer.append(CSV_QUOTE).append(escapeCSV(employee.getPhone())).append(CSV_QUOTE);
                writer.append(CSV_SEPARATOR);
                writer.append(CSV_QUOTE).append(escapeCSV(employee.getDepartment())).append(CSV_QUOTE);
                writer.append("\n");
            }
        }

        // Make file visible to other apps
        context.sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, Uri.fromFile(file)));

        return file.getAbsolutePath();
    }

    public static void openCSVFile(Context context, String filePath) {
        File file = new File(filePath);
        Uri uri;
        
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            uri = FileProvider.getUriForFile(context, context.getPackageName() + ".fileprovider", file);
        } else {
            uri = Uri.fromFile(file);
        }
        
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setDataAndType(uri, "text/plain");
        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        
        try {
            context.startActivity(intent);
        } catch (Exception e) {
            // Fallback: just show success message
        }
    }
}
