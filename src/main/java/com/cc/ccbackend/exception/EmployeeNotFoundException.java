package com.cc.ccbackend.exception;

import java.util.UUID;

public class EmployeeNotFoundException extends RuntimeException{
    public EmployeeNotFoundException(UUID id) {
        super(String.format("Employee with ID: %s does not exist.",id.toString()));
    }
}
