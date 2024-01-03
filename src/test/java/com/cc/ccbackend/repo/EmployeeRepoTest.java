package com.cc.ccbackend.repo;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import com.cc.ccbackend.exception.EmployeeNotFoundException;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

@ExtendWith(MockitoExtension.class)
public class EmployeeRepoTest {

    @Mock
    private JdbcTemplate jdbcTemplate;
    @InjectMocks
    private EmployeeRepo onTest;

    @Test
    public void getEmployeeById_whenEmployeeDoesNotExist_thenThrowException() {
        UUID id = UUID.randomUUID();
        when(jdbcTemplate.queryForObject(anyString(), (RowMapper<Object>) any(), any())).thenThrow(IncorrectResultSizeDataAccessException.class);
        assertThrows(EmployeeNotFoundException.class, () -> onTest.getEmployeeById(id));
    }
}
