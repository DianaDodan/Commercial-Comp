package com.cc.ccbackend.repo;

import com.cc.ccbackend.domain.Skill;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class SkillRepo {

    private final JdbcTemplate jdbcTemplate;

    public List<Skill> getAllSkills() {
        return jdbcTemplate.query("select * from skill",
            new BeanPropertyRowMapper<>(Skill.class));
    }

    public void create(Skill skill) {
        jdbcTemplate.update("insert into skill (name) values (?)",
            skill.getName());
    }
}
