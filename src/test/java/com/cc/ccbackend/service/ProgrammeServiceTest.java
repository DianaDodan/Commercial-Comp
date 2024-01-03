package com.cc.ccbackend.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.cc.ccbackend.domain.Programme;
import com.cc.ccbackend.exception.InvalidProgrammeSupervisorException;
import com.cc.ccbackend.exception.NullProgrammeException;
import com.cc.ccbackend.repo.EmployeeRepo;
import com.cc.ccbackend.repo.ProgrammeRepo;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ProgrammeServiceTest {

    @Mock
    private ProgrammeRepo programmeRepo;
    @Mock
    private EmployeeRepo employeeRepo;
    @InjectMocks
    private ProgrammeService onTest;

    @Test
    public void createProgramme_whenIsSupervisor_thenCreateProgramme() {
        //given
        Programme programme = new Programme("Cleaning", UUID.randomUUID());

        //when
        when(employeeRepo.isSupervisor(any())).thenReturn(true);

        //then
        onTest.createProgramme(programme);
        verify(programmeRepo).createProgramme(any());
    }

    @Test
    public void createProgramme_whenIsNotSupervisor_thenThrowException() {
        //given
        Programme programme = new Programme("Cleaning", UUID.randomUUID());

        //when
        when(employeeRepo.isSupervisor(any())).thenReturn(false);

        //then
        assertThrows(InvalidProgrammeSupervisorException.class,() -> onTest.createProgramme(programme));
    }

    @Test
    public void createProgramme_whenProgrammeIsNull_thenThrowException() {
        //given
        Programme programme = null;

        //then
        assertThrows(NullProgrammeException.class,() -> onTest.createProgramme(programme));
    }

    @Test
    public void getAllProgrammes_whenExists_thenReturnAllProgrammes() {
        //given
        Programme programme1 = new Programme("Cleaning", UUID.randomUUID());
        Programme programme2 = new Programme("Mopping", UUID.randomUUID());
        List<Programme> expected = List.of(programme1, programme2);

        //when
        when(programmeRepo.getAllProgrammes()).thenReturn(expected);

        //then
        assertEquals(expected, onTest.getAllProgrammes());
    }

    @Test
    public void getProgrammeById_whenProgrammeExists_thenReturnProgramme() {
        //given
        UUID id = UUID.randomUUID();
        Programme programme = new Programme(id, "Cleaning", UUID.randomUUID());

        //when
        when(programmeRepo.getProgrammeById(id)).thenReturn(programme);

        //then
        assertEquals(programme, onTest.getProgrammeById(id));
    }
}