package com.cc.ccbackend.service;

import com.cc.ccbackend.domain.Programme;
import com.cc.ccbackend.exception.InvalidProgrammeSupervisorException;
import com.cc.ccbackend.exception.NullProgrammeException;
import com.cc.ccbackend.repo.EmployeeRepo;
import com.cc.ccbackend.repo.ProgrammeRepo;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProgrammeService {
    private final ProgrammeRepo programmeRepo;
    private final EmployeeRepo employeeRepo;

    public void createProgramme(Programme programme) {
        if (programme == null) {
            throw new NullProgrammeException();
        }
        if (!employeeRepo.isSupervisor(programme.getSupervisorId())) {
            throw new InvalidProgrammeSupervisorException(programme.getSupervisorId());
        }
        programmeRepo.createProgramme(programme);
    }

    public List<Programme> getAllProgrammes() {
        return programmeRepo.getAllProgrammes();
    }

    public Programme getProgrammeById(UUID id) {
        return programmeRepo.getProgrammeById(id);
    }
}
