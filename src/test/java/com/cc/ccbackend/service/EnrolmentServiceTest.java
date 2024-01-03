package com.cc.ccbackend.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

import com.cc.ccbackend.domain.Employee;
import com.cc.ccbackend.domain.Employee.Role;
import com.cc.ccbackend.domain.Enrolment;
import com.cc.ccbackend.domain.Programme;
import com.cc.ccbackend.repo.EnrolmentRepo;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class EnrolmentServiceTest {

    @Mock
    EnrolmentRepo enrolmentRepo;
    @InjectMocks
    EnrolmentService onTest;

    @Test
    public void create_whenEmployeeOnProgramme_thenCreateEnrolment() {
        //given
        Enrolment enrolment = new Enrolment();

        //then
        onTest.create(enrolment);
        verify(enrolmentRepo).create(any());

    }
}
