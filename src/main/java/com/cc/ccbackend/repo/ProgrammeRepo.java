package com.cc.ccbackend.repo;

import com.cc.ccbackend.domain.Programme;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@AllArgsConstructor
@Repository
public class ProgrammeRepo {
    private final JdbcTemplate jdbcTemplate;

    public void createProgramme(Programme programme) {
        jdbcTemplate.update("insert into programme (name,supervisor_id) values (?,?)",
            programme.getName(),programme.getSupervisorId());
    }

    public List<Programme> getAllProgrammes() {
        return jdbcTemplate.query("select * from programme",
            new BeanPropertyRowMapper<>(Programme.class));
    }

    public Programme getProgrammeById(UUID id) {
        return jdbcTemplate.queryForObject("SELECT * FROM programme WHERE id = ?",
            new BeanPropertyRowMapper<>(Programme.class),
            id.toString());

    }

}
