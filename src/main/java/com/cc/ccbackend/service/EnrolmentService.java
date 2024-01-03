package com.cc.ccbackend.service;

import com.cc.ccbackend.domain.Enrolment;
import com.cc.ccbackend.repo.EnrolmentRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EnrolmentService {

    private final EnrolmentRepo enrolmentRepo;

    public void create(Enrolment enrolment) {
        enrolmentRepo.create(enrolment);
    }
}
