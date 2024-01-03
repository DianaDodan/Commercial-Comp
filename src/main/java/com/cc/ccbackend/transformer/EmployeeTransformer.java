package com.cc.ccbackend.transformer;

import com.cc.ccbackend.domain.Employee;
import com.cc.ccbackend.dto.EmployeeDto;
import org.springframework.stereotype.Component;

@Component
public class EmployeeTransformer {

    public Employee transform(EmployeeDto employeeDto) {
        return new Employee(employeeDto.getName(), Employee.Role.valueOf(employeeDto.getRole().name()));
    }
}
