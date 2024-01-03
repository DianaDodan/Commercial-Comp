package com.cc.ccbackend.service;

import com.cc.ccbackend.domain.Employee;
import com.cc.ccbackend.repo.EmployeeRepo;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeeService {
    private final EmployeeRepo employeeRepo;

    public void createEmployee(Employee employee) {
        employeeRepo.createEmployee(employee);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepo.getAllEmployees();
    }

    public Employee getEmployeeById(UUID id) {
        return employeeRepo.getEmployeeById(id);
    }
}
