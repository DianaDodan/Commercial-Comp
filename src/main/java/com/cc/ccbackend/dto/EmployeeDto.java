package com.cc.ccbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmployeeDto {
    private String name;
    private Role role;
    private String username;
    private String password;


    public enum Role {
        MANAGER,
        SUPERVISOR,
        TRAINEE;
    }
}

