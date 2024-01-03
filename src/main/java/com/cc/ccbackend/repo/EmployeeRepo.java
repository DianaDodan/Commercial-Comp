package com.cc.ccbackend.repo;

import com.cc.ccbackend.domain.Employee;
import com.cc.ccbackend.exception.EmployeeNotFoundException;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class EmployeeRepo {
    private final JdbcTemplate jdbcTemplate;

    public void createEmployee(Employee employee) {
        jdbcTemplate.update("insert into employee (name,role) values (?,?)",
            employee.getName(),employee.getRole().name());
    }

    public List<Employee> getAllEmployees() {
        return jdbcTemplate.query("select * from employee",
            new BeanPropertyRowMapper<>(Employee.class));
    }

    public Employee getEmployeeById(UUID id) {
        try {
            return jdbcTemplate.queryForObject("select * from employee where id = ?",
                new BeanPropertyRowMapper<>(Employee.class),
                id.toString());
        } catch (IncorrectResultSizeDataAccessException e) {
            throw new EmployeeNotFoundException(id);
        }
    }

    public Boolean isSupervisor(UUID id) {
         return !jdbcTemplate.query(
            "SELECT * FROM employee WHERE role = 'SUPERVISOR'"
                + "and id = ?",
            new BeanPropertyRowMapper<>(Employee.class),
            id.toString()).isEmpty();
    }
}
