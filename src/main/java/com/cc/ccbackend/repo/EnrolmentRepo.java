package com.cc.ccbackend.repo;

import com.cc.ccbackend.domain.Enrolment;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class EnrolmentRepo {

    private final JdbcTemplate jdbcTemplate;

    public void create(Enrolment enrolment) {
        jdbcTemplate.update("INSERT INTO enrolment VALUES (?,?)", enrolment.getEmployeeId(), enrolment.getProgrammeId());
    }
}
