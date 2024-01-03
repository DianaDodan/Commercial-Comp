package com.cc.ccbackend.service;

import com.cc.ccbackend.domain.Skill;
import com.cc.ccbackend.repo.SkillRepo;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SkillService {

    private final SkillRepo skillRepo;

    public List<Skill> getAllSkills() {
        return skillRepo.getAllSkills();
    }

    public void create(Skill skill) {
        skillRepo.create(skill);
    }
}
