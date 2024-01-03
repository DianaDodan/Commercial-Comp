package com.cc.ccbackend.repo;

import com.cc.ccbackend.domain.Proficiency;
import com.cc.ccbackend.domain.UserProficiency;
import com.cc.ccbackend.domain.request.TrainingSkillsProficiencyRequest;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.UUID;

@Repository
@AllArgsConstructor
public class ProficiencyRepo {

    private final JdbcTemplate jdbcTemplate;

    public Collection<UserProficiency> getAllForRequest(TrainingSkillsProficiencyRequest request) {
        return jdbcTemplate.query("SELECT s.id skill_id, s.name, p.proficiency FROM skill_on_programme sop " +
                "JOIN skill s ON s.id = sop.skill_id " +
                "JOIN proficiency p ON s.id = p.skill_id " +
                "WHERE sop.programme_id = ? AND p.employee_id = ?", new BeanPropertyRowMapper<>(UserProficiency.class), 
                request.getProgrammeId(), 
                request.getEmployeeId());
    }

    public void deleteForEmployee(UUID employeeId) {
        jdbcTemplate.update("DELETE FROM proficiency WHERE employee_id = ?", employeeId);
    }

    public void create(Proficiency proficiency) {
        proficiency.getSkillProficiencies().forEach(skillProficiency -> {
            jdbcTemplate.update("INSERT INTO proficiency VALUES (?,?,?)", proficiency.getEmployeeId(), skillProficiency.getSkillId(), skillProficiency.getProficiencyLevel());
        });
    }
}
