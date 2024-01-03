package com.cc.ccbackend.transformer;

import com.cc.ccbackend.domain.Login;
import com.cc.ccbackend.dto.EmployeeDto;
import org.springframework.stereotype.Component;

@Component
public class LoginTransformer {

    public Login transform(EmployeeDto employeeDto) {
        return new Login(employeeDto.getUsername(), employeeDto.getPassword());
    }
}
