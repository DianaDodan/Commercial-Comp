package com.cc.ccbackend.controller;

import com.cc.ccbackend.domain.Enrolment;
import com.cc.ccbackend.service.EnrolmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/enrolment")
@AllArgsConstructor
public class EnrolmentController {

    private final EnrolmentService enrolmentService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Enrolment enrolment) {
        enrolmentService.create(enrolment);
        return ResponseEntity.ok().build();
    }
}
