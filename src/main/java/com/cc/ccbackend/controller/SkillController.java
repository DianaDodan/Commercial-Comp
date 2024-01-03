package com.cc.ccbackend.controller;

import com.cc.ccbackend.domain.Skill;
import com.cc.ccbackend.service.SkillService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping("/skill")
public class SkillController {

    private final SkillService skillService;

    @GetMapping
    public ResponseEntity<List<Skill>> getAllSkills() {
        return  ResponseEntity.ok(skillService.getAllSkills());
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Skill skill) {
        skillService.create(skill);
        return ResponseEntity.ok().build();
    }
}
