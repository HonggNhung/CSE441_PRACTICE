package com.example.prac02;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.lifecycle.ViewModelProvider;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EmployeeViewModel employeeViewModel;
    private TextView resultTextView;
    private EditText staffIdEditText, fullNameEditText, birthDateEditText, salaryEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Tham chiếu tới các thành phần giao diện
        resultTextView = findViewById(R.id.resultTextView);
        staffIdEditText = findViewById(R.id.staffIdEditText);
        fullNameEditText = findViewById(R.id.fullNameEditText);
        birthDateEditText = findViewById(R.id.birthDateEditText);
        salaryEditText = findViewById(R.id.salaryEditText);
        Button addStaffButton = findViewById(R.id.addStaffButton);

        // Khởi tạo ViewModel
        employeeViewModel = new ViewModelProvider(this).get(EmployeeViewModel.class);

        // Quan sát thay đổi trong danh sách nhân viên
        employeeViewModel.getEmployees().observe(this, employees -> {
            if (employees.isEmpty()) {
                resultTextView.setText("No Result!");
            } else {
                StringBuilder result = new StringBuilder();
                for (Employee employee : employees) {
                    result.append(employee.toString()).append("\n");
                }
                resultTextView.setText(result.toString());
            }
        });

        // Xử lý sự kiện khi nhấn nút "Add New Staff"
        addStaffButton.setOnClickListener(v -> {
            String id = staffIdEditText.getText().toString();
            String name = fullNameEditText.getText().toString();
            String birthDate = birthDateEditText.getText().toString();
            String salary = salaryEditText.getText().toString();

            if (!id.isEmpty() && !name.isEmpty() && !birthDate.isEmpty() && !salary.isEmpty()) {
                Employee newEmployee = new Employee(id, name, birthDate, salary);
                employeeViewModel.addEmployee(newEmployee);

                // Xóa dữ liệu sau khi thêm
                staffIdEditText.setText("");
                fullNameEditText.setText("");
                birthDateEditText.setText("");
                salaryEditText.setText("");
            }
        });
    }
}
