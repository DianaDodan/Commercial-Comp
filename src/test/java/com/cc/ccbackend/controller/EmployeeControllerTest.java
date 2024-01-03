package com.cc.ccbackend.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import com.cc.ccbackend.dto.EmployeeDto;
import com.cc.ccbackend.dto.EmployeeDto.Role;
import com.cc.ccbackend.service.EmployeeService;
import com.cc.ccbackend.service.LoginService;
import com.cc.ccbackend.transformer.EmployeeTransformer;
import com.cc.ccbackend.transformer.LoginTransformer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

@ExtendWith(MockitoExtension.class)
public class EmployeeControllerTest {

    @Mock
    private EmployeeService employeeService;
    @Mock
    private LoginTransformer loginTransformer;
    @Mock
    private EmployeeTransformer employeeTransformer;
    @Mock
    private LoginService loginService;
    @InjectMocks
    private EmployeeController onTest;

    @Test
    public void createEmployee_whenEmployeeIsManager_thenCreateLoginAndEmployee(){
        //given
        EmployeeDto employeeDto = new EmployeeDto("derek", Role.MANAGER, "abc", "abc");
        //then
        assertEquals(HttpStatus.OK, onTest.createEmployee(employeeDto).getStatusCode());
        verify(loginService).createLogin(any());
        verify(employeeService).createEmployee(any());
    }

    @Test
    public void createEmployee_whenEmployeeIsSupervisor_thenCreateLoginAndEmployee(){
        //given
        EmployeeDto employeeDto = new EmployeeDto("derek", Role.SUPERVISOR, "abc", "abc");
        //then
        assertEquals(HttpStatus.OK, onTest.createEmployee(employeeDto).getStatusCode());
        verify(loginService).createLogin(any());
        verify(employeeService).createEmployee(any());
    }

    @Test
    public void createEmployee_whenEmployeeIsTrainee_thenCreateEmployee(){
        //given
        EmployeeDto employeeDto = new EmployeeDto("derek", Role.TRAINEE, "abc", "abc");
        //then
        assertEquals(HttpStatus.OK, onTest.createEmployee(employeeDto).getStatusCode());
        verify(loginService, times(0)).createLogin(any());
        verify(employeeService).createEmployee(any());
    }
}
