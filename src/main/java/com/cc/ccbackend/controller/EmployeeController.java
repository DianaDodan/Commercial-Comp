package com.cc.ccbackend.controller;

import com.cc.ccbackend.domain.Employee;
import com.cc.ccbackend.dto.EmployeeDto;
import com.cc.ccbackend.dto.EmployeeDto.Role;
import com.cc.ccbackend.service.EmployeeService;
import com.cc.ccbackend.service.LoginService;
import com.cc.ccbackend.transformer.EmployeeTransformer;
import com.cc.ccbackend.transformer.LoginTransformer;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;
    private final EmployeeTransformer employeeTransformer;
    private final LoginTransformer loginTransformer;
    private final LoginService loginService;

    @PostMapping
    public ResponseEntity<?> createEmployee(@RequestBody EmployeeDto employeeDto) {
        if (!Objects.equals(employeeDto.getRole(), Role.TRAINEE)) {
            loginService.createLogin(loginTransformer.transform(employeeDto));
        }
        employeeService.createEmployee(employeeTransformer.transform(employeeDto));
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() {
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") UUID id) {
        return ResponseEntity.ok(employeeService.getEmployeeById(id));
    }
}
