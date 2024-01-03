package com.cc.ccbackend.service;

import com.cc.ccbackend.domain.Proficiency;
import com.cc.ccbackend.domain.UserProficiency;
import com.cc.ccbackend.domain.request.TrainingSkillsProficiencyRequest;
import com.cc.ccbackend.repo.ProficiencyRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ProficiencyService {

    private final ProficiencyRepo proficiencyRepo;

    public Collection<UserProficiency> getAllForRequest(TrainingSkillsProficiencyRequest request) {
        return proficiencyRepo.getAllForRequest(request);
    }

    public void removeForEmployee(UUID employeeId) {
        proficiencyRepo.deleteForEmployee(employeeId);
    }

    public void create(Proficiency proficiency) {
        proficiencyRepo.create(proficiency);
    }
}
