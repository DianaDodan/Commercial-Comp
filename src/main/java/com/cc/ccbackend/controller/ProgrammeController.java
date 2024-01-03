package com.cc.ccbackend.controller;

import com.cc.ccbackend.domain.Programme;
import com.cc.ccbackend.service.ProgrammeService;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping("/programme")
public class ProgrammeController {
    private final ProgrammeService programmeService;

    @PostMapping
    public ResponseEntity<?> createProgramme(@RequestBody Programme programme) throws Exception {
        programmeService.createProgramme(programme);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<Programme>> getAllProgrammes() {
        return ResponseEntity.ok(programmeService.getAllProgrammes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Programme> getProgrammeById(@PathVariable("id") UUID id) {
        return ResponseEntity.ok(programmeService.getProgrammeById(id));
    }
}
