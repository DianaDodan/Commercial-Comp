package com.cc.ccbackend.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.cc.ccbackend.domain.Employee;
import com.cc.ccbackend.domain.Employee.Role;
import com.cc.ccbackend.repo.EmployeeRepo;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {

    @Mock
    EmployeeRepo employeeRepo;
    @InjectMocks
    EmployeeService onTest;

    @Test
    public void createEmployee_WhenEmployeeIsValid_ThenCreateEmployee() {
        //given
        Employee employee = new Employee("mike", Role.TRAINEE);

        //then
        onTest.createEmployee(employee);
        verify(employeeRepo).createEmployee(employee);
    }

    @Test
    public void getAllEmployees_WhenEmployeesExist_ThenReturnAll() {
        //given
        Employee employee1 = new Employee("mike", Role.TRAINEE);
        Employee employee2 = new Employee("carol", Role.TRAINEE);

        List<Employee> expected = List.of(employee1, employee2);

        //when
        when(employeeRepo.getAllEmployees()).thenReturn(expected);

        //then
        assertEquals(expected, onTest.getAllEmployees());
    }

    @Test
    public void getEmployeeById_whenEmployeeExists_thenReturnEmployee() {
        //given
        UUID id = UUID.randomUUID();
        Employee employee = new Employee(id, "mike",  Role.TRAINEE);

        //when
        when(employeeRepo.getEmployeeById(id)).thenReturn(employee);

        //then
        assertEquals(employee, onTest.getEmployeeById(id));
    }
}
