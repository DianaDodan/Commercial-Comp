package com.cc.ccbackend.controller;

import com.cc.ccbackend.domain.Proficiency;
import com.cc.ccbackend.domain.request.TrainingSkillsProficiencyRequest;
import com.cc.ccbackend.service.ProficiencyService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/proficiency")
@AllArgsConstructor
public class ProficiencyController {

    private final ProficiencyService proficiencyService;

    @GetMapping
    public ResponseEntity<?> getForEmployee(@RequestBody TrainingSkillsProficiencyRequest request) {
        return ResponseEntity.ok(proficiencyService.getAllForRequest(request));
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Proficiency proficiency) {
        proficiencyService.removeForEmployee(proficiency.getEmployeeId());
        proficiencyService.create(proficiency);
        return ResponseEntity.ok().build();
    }
}
