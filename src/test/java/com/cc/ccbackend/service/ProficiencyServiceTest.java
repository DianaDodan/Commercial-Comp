package com.cc.ccbackend.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.cc.ccbackend.domain.Proficiency;
import com.cc.ccbackend.domain.UserProficiency;
import com.cc.ccbackend.repo.ProficiencyRepo;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ProficiencyServiceTest {

    @Mock
    private ProficiencyRepo proficiencyRepo;
    @InjectMocks
    private ProficiencyService onTest;

    @Test
    public void create_whenProficiencyIsValid_thenCreateProficiency() {
        //given
        Proficiency proficiency = new Proficiency();

        //then
        onTest.create(proficiency);
        verify(proficiencyRepo).create(proficiency);
    }

    @Test
    public void removeForEmployee_whenEmployeeExists_thenDeleteEmployeeProficiency() {
        //given
        UUID id = UUID.randomUUID();

        //then
        onTest.removeForEmployee(id);
        verify(proficiencyRepo).deleteForEmployee(id);
    }

    @Test
    public void getAllForRequest_whenRequestIsValid_thenReturnAllProficiencies() {
        //given
        UserProficiency userProficiency = new UserProficiency();
        List<UserProficiency> list = List.of(userProficiency);

        //when
        when(proficiencyRepo.getAllForRequest(any())).thenReturn(list);

        //then
        Assertions.assertEquals(list, onTest.getAllForRequest(any()).stream().toList());
    }
}
