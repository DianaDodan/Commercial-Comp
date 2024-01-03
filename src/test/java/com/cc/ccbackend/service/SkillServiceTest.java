package com.cc.ccbackend.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.cc.ccbackend.domain.Skill;
import com.cc.ccbackend.repo.SkillRepo;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class SkillServiceTest {

    @Mock
    private SkillRepo skillRepo;
    @InjectMocks
    private SkillService onTest;

    @Test
    public void create_WhenSkillIsValid_ThenCreateSkill() {
        //given
        Skill skill = new Skill("speak");

        //then
       onTest.create(skill);
       verify(skillRepo).create(skill);
    }

    @Test
    public void getAllSkills_WhenSkillsExist_ThenReturnAll() {
        //given
        Skill skill1 = new Skill("Cleaning");
        Skill skill2 = new Skill("Mopping");
        List<Skill> expected = List.of(skill1, skill2);

        //when
        when(skillRepo.getAllSkills()).thenReturn(expected);

        //then
        assertEquals(expected, onTest.getAllSkills());
    }
}
